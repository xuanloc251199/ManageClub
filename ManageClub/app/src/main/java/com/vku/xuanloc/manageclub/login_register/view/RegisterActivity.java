//package com.vku.xuanloc.manageclub.login_register.view;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ActivityOptions;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.PatternMatcher;
//import android.util.Pair;
//import android.util.Patterns;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.FirebaseDatabase;
//import com.vku.xuanloc.manageclub.R;
//import com.vku.xuanloc.manageclub.login_register.model.User;
//import com.vku.xuanloc.manageclub.main.view.NavigationBarActivity;
//
//import java.util.Objects;
//
//public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
//
//    private RelativeLayout rlayout;
//    private Animation animation;
//    private TextView mTvHaveAcc, mTvBanner;
//    private ProgressBar mProgressBar;
//
//
//    private EditText mEdtEmail, mEdtUserName, mEdtFullName, mEdtPassword, mEdtRetypePass;
//    private Button mBtSignUp;
//    private FirebaseAuth mFirebaseAuth;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        mappedId();
//
//        eventClick();
//
//        setAnimation();
//
//        mFirebaseAuth = FirebaseAuth.getInstance();
//
//    }
//
//    //Mapped Id
//    private void mappedId(){
//        rlayout = findViewById(R.id.re_rLayout_id);
//        mTvHaveAcc = findViewById(R.id.re_tvHaveAcc_id);
//        mTvBanner = findViewById(R.id.re_tvBanner_id);
//        mProgressBar = findViewById(R.id.re_progress_id);
//
//        mEdtEmail = findViewById(R.id.re_edtEmail_id);
//        mEdtUserName = findViewById(R.id.re_edtUserNam_id);
//        mEdtFullName = findViewById(R.id.re_edtFullName_id);
//        mEdtPassword = findViewById(R.id.re_edtPass_id);
//        mEdtRetypePass = findViewById(R.id.re_edtRetypePass_id);
//        mBtSignUp = findViewById(R.id.re_btSignUp_id);
//    }
//
//    //Event
//    private void eventClick(){
//
//        mBtSignUp.setOnClickListener(this);
//
//        mTvBanner.setOnClickListener(this);
//
//        mTvHaveAcc.setOnClickListener(this);
//
//    }
//
//    //Animation
//    private void setAnimation(){
//        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
//        rlayout.setAnimation(animation);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home :
//                onBackPressed();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        if (view == mTvHaveAcc){
//            Intent intent   = new Intent(RegisterActivity.this, LoginActivity.class);
//            Pair[] pairs    = new Pair[1];
//            pairs[0] = new Pair<View,String>(mTvBanner,"mTvBanner");
//            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(RegisterActivity.this,pairs);
//            startActivity(intent,activityOptions.toBundle());
//        }
//
//        switch (view.getId()){
//            case R.id.re_btSignUp_id:
//                btSignUpClick();
//                break;
//        }
//    }
//
//    private void btSignUpClick() {
//
//        final String email = mEdtEmail.getText().toString().trim();
//        final String username = mEdtEmail.getText().toString().trim();
//        final String fullName = mEdtEmail.getText().toString().trim();
//        final String password = mEdtPassword.getText().toString().trim();
//        String retypePassword = mEdtRetypePass.getText().toString().trim();
//
//        if (email.isEmpty()){
//            mEdtEmail.setError("Hãy nhập địa chỉ Email của bạn!");
//            mEdtEmail.requestFocus();
//            return;
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            mEdtEmail.setError("Vui lòng nhập đúng định dạng email!");
//            mEdtEmail.requestFocus();
//            return;
//        }
//
//        if (username.isEmpty()){
//            mEdtUserName.setError("Hãy nhập Họ và Tên của bạn!");
//            mEdtUserName.requestFocus();
//            return;
//        }
//
//        if (fullName.isEmpty()){
//            mEdtFullName.setError("Hãy nhập Họ và Tên của bạn!");
//            mEdtFullName.requestFocus();
//        }
//
//        if (password.isEmpty()){
//            mEdtPassword.setError("Hãy nhập Mật Khẩu của bạn!");
//            mEdtPassword.requestFocus();
//            return;
//        }
//
//        if (password.length() < 6){
//            mEdtPassword.setError("Mật Khẩu có ít nhất 6 ký tự!");
//            mEdtPassword.requestFocus();
//            return;
//        }
//
//        if (retypePassword.isEmpty()){
//            mEdtRetypePass.setError("Hãy nhập lại Mật Khẩu của bạn!");
//            mEdtRetypePass.requestFocus();
//            return;
//        }
//
//        if (! password.equals(retypePassword)){
//            mEdtRetypePass.setError("Mật Khẩu không trung khớp!");
//            mEdtRetypePass.requestFocus();
//        }
//
//        mProgressBar.setVisibility(View.VISIBLE);
//        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if (! task.isSuccessful()){
//
//                            User user = new User(email, username, password, fullName);
//
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(RegisterActivity.this, "Đăng Ký thành công!",
//                                                Toast.LENGTH_SHORT).show();
//                                        mProgressBar.setVisibility(View.GONE);
//                                    }else {
//                                        Toast.makeText(RegisterActivity.this, "Đăng Ký thất bại! Vui lòng thử lại",
//                                                Toast.LENGTH_SHORT).show();
//                                        mProgressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                        }else {
//                            Intent intent = new Intent(RegisterActivity.this, NavigationBarActivity.class);
//                            startActivity(intent);
//                        }
//                    }
//                });
//    }
//
//}
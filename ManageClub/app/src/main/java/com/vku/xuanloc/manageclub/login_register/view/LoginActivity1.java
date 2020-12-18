//package com.vku.xuanloc.manageclub.login_register.view;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.vku.xuanloc.manageclub.R;
//import com.vku.xuanloc.manageclub.main.view.NavigationBarActivity;
//
//public class LoginActivity1 extends AppCompatActivity implements View.OnClickListener {
//
//    private RelativeLayout rLayout;
//    private Animation animation;
//    private ImageButton btRegister;
//    private TextView mTvLogin;
//
//    private EditText edtEmail, edtPassword;
//    private Button btLogin;
//
//    private FirebaseAuth mAuth;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        mappedId();
//
//        eventClick();
//
//        setAnimation();
//
//        // Initialize Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//
//    }
//
//
//    //Mapped Id
//    private void mappedId(){
//        rLayout = findViewById(R.id.lg_rLayout_id);
//        btRegister = findViewById(R.id.lg_btRegister_id);
//        mTvLogin = findViewById(R.id.lg_tvLogin_id);
//
//
//        edtEmail = findViewById(R.id.lg_edt_email_id);
//        edtPassword = findViewById(R.id.id_edt_pass_id);
//        btLogin = findViewById(R.id.lg_btLogin_id);
//
//    }
//
//    //Animation
//    private void setAnimation(){
//        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
//        rLayout.setAnimation(animation);
//    }
//
//    //Event
//    private void eventClick(){
//        btRegister.setOnClickListener(this);
//
//        btLogin.setOnClickListener(this);
//
////        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
////
////            @Override
////            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
////
////                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
////                if (mFirebaseUser != null){
////
////                    Toast.makeText(LoginActivity.this, "Đăng Nhập thành công!", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(LoginActivity.this, NavigationBarActivity.class);
////                    startActivity(intent);
////
////                }
////                else {
////                    Toast.makeText(LoginActivity.this, "Hãy đăng nhập!", Toast.LENGTH_SHORT).show();
////
////                }
////            }
////        };
//
//    }
//
//
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.lg_btRegister_id:
//                Intent intent = new Intent(LoginActivity1.this, RegisterActivity.class);
//                startActivity(intent);
//                break;
//
//        }
//    }
//}

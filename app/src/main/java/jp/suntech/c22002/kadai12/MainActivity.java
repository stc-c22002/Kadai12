package jp.suntech.c22002.kadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttonオブジェクト取得 p100,104
        Button btSend=findViewById(R.id.btSend);
        Button btConfirm=findViewById(R.id.btConfirm);
        Button btClear=findViewById(R.id.btClear);

        //インスタンスを生成 p100
        ClickListener listener=new ClickListener();

        //ボタンにリスナ設定 p100,104
        btSend.setOnClickListener(listener);
        btClear.setOnClickListener(listener);
        btConfirm.setOnClickListener(listener);
    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //EditText取得 p104
            EditText inputName=findViewById(R.id.etName);
            EditText inputMail=findViewById(R.id.etMail);
            EditText inputMailTitle=findViewById(R.id.etMailTitle);
            EditText inputComment=findViewById(R.id.etComment);

            //押されてたボタン取得 104
            int id=v.getId();

            if(id==R.id.btSend){//送信 toast:p113 文字列取得:p104
                //入力された文字取得
                String NameStr=inputName.getText().toString();
                String MailStr=inputMail.getText().toString();
                String MailTitleStr=inputMailTitle.getText().toString();
                String CommentStr=inputComment.getText().toString();

                String show = "名前："+NameStr+", メールアドレス："+MailStr+"\n タイトル："+MailTitleStr+", 質疑応答："+CommentStr;

                //トーストの表示(snackber)
                //Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
                Snackbar.make(v, show, Snackbar.LENGTH_SHORT).show();

            }else if(id==R.id.btClear){//クリア 104
                inputName.setText("");
                inputMail.setText("");
                inputMailTitle.setText("");
                inputComment.setText("");
            }
            else if(id==R.id.btConfirm){//確認 ダイアログ:p119
                //入力された文字取得
                String NameStr=inputName.getText().toString();
                String MailStr=inputMail.getText().toString();
                String MailTitleStr=inputMailTitle.getText().toString();
                String CommentStr=inputComment.getText().toString();

                String show = "名前："+NameStr+", メールアドレス："+MailStr+"\n タイトル："+MailTitleStr+", 質疑応答："+CommentStr;

                //トーストの表示(snackber)
                //Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
                Snackbar.make(v, show, Snackbar.LENGTH_SHORT).show();

                ConfirmDialogFragment dialogFragment=new ConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"ConfirmDialogFragment");
            }
        }
    }
}
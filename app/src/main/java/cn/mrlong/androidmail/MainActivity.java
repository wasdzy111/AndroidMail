package cn.mrlong.androidmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MailEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        entity = new MailEntity(
                "smtp.sina.cn",     //服务器地址
                "25",               //服务器端口
                "",       //你的邮箱
                "",          //你的邮箱密码或者授权码
                "",    //你的地址 （一般与你的邮箱相同）
                "",    //目的地址
                true,                    //是否身份认证
                "邮件标题",                   //邮件标题
                "邮件内容",             //邮件正文
                null);


        new Thread() {
            @Override
            public void run() {
                boolean flag = MailUtils.sendTextMail(entity);
                if (flag) {
                    Log.e("===>", "发送成功");
                    return;
                }
                Log.e("===>", "发送失败");
            }
        }.start();
    }
}

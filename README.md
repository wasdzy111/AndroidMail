# AndroidMail

#### 项目介绍
使用javaMail在android发送邮件
#### 使用说明
获取方式
Step 1. Add it in your root build.gradle at the end of repositories:
~~~
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
~~~
Step 2. Add the dependency
~~~
dependencies {
	        implementation 'com.gitee.wasdzy:AndroidMail:1.0.0'
	}
~~~
6.0之后请求网络权限
~~~
 <uses-permission android:name="android.permission.INTERNET" />
~~~
发送代码
~~~
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

        //在子线程中请求数据
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
~~~

#### 参与贡献

1. 伟大的网友

package com.myapp.android.projectandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Notify extends AppCompatActivity {
    private EditText skill;
    private Button btn;
    String course;
    SQLiteDatabase courses,interest;
     String[] l={"artificial intelligence","python","python","cryptography","crytography"};
     String[] s={"https://www.linkedin.com/learning/artificial-intelligence-foundations-thinking-machines",
             "https://www.linkedin.com/learning/python-3-essential-training",
             "https://www.linkedin.com/learning/python-for-data-science-essential-training",
             "https://www.linkedin.com/learning/learning-bitcoin/tracking-bitcoin",
             "https://www.linkedin.com/learning/learning-cryptography-and-network-security/introducing-common-cryptographic-concepts-and-terminology"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        /*TextView tv;
        //interest=((MyApplication)getApplication()).interest;
        courses=openOrCreateDatabase("c",MODE_PRIVATE,null);
        //interest=openOrCreateDatabase("d",MODE_PRIVATE,null);
        courses.execSQL("create table if not exists cour(Name varchar,url varchar)");
        //interest.execSQL("create table if not exists skill_interest(Name varchar);");

        createDb();

        Cursor ch= interest.rawQuery("select distinct(Name) from skill_interest;",null);
        LinearLayout ll1=(LinearLayout)findViewById(R.id.ll1);
        String msg="We have found  in:";
        tv = new TextView(Notify.this);
        tv.setText(msg);
        ll1.addView(tv);
        if (ch != null ) {
            if  (ch.moveToFirst()) {
                do {
                    String dir = ch.getString(ch.getColumnIndex("Name"));
                    /*Cursor a=interest.rawQuery("select count(url) as co from cour where Name='"+dir+"';",null);
                    int var=0;
                    if(a.moveToFirst())
                    {
                        var=a.getInt(a.getColumnIndex("co"));
                    }
                    char v=(char)(var+48);
                    String msg="We have found "+v+"courses you may be interested in:";
                    tv = new TextView(Notify.this);
                    tv.setText(msg);
                    ll1.addView(tv);*/
                    /*Cursor dh=interest.rawQuery("select url from cour where Name='"+dir+"';",null);
                    if(dh!=null)
                    {
                        if(dh.moveToFirst())
                        {
                            do {
                                String dr=dh.getString(dh.getColumnIndex("url"));
                                tv = new TextView(Notify.this);
                                tv.setText(dr);
                                ll1.addView(tv);
                            }while (dh.moveToNext());
                        }
                    }

                }while (ch.moveToNext());
            }
        }*/
        // interest.execSQL("delete from skill_interest;");

    }

   /* private void createDb() {
        for(int i=0;i<5;i++)
            courses.execSQL("insert into cour values ('"+l[i]+"','"+s[i]+"');");
    }*/

}

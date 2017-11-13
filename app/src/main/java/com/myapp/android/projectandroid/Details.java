package com.myapp.android.projectandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Details extends AppCompatActivity {


    private EditText skill;
    private Button btn;
    String course;
    SQLiteDatabase courses,interest;
     String[] l={"artificial intelligence","python","python","cryptography","crytography"
     };
     String[] s={"https://www.linkedin.com/learning/artificial-intelligence-foundations-thinking-machines",
             "https://www.linkedin.com/learning/python-3-essential-training",
             "https://www.linkedin.com/learning/python-for-data-science-essential-training",
             "https://www.linkedin.com/learning/learning-bitcoin/tracking-bitcoin",
             "https://www.linkedin.com/learning/learning-cryptography-and-network-security/introducing-common-cryptographic-concepts-and-terminology"};

     String[] cur={"artificial intelligence","cryptography"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        skill=(EditText)findViewById(R.id.newSkill);
        btn=(Button)findViewById(R.id.addb);

        courses=openOrCreateDatabase("d",MODE_PRIVATE,null);
        interest=openOrCreateDatabase("e",MODE_PRIVATE,null);
        courses.execSQL("create table if not exists cour(Name varchar,url varchar);");
        interest.execSQL("create table if not exists skill_interest(Name varchar);");
        createDb();
        Cursor c= interest.rawQuery("select distinct(Name) from skill_interest;",null);
        final LinearLayout  ll=(LinearLayout)findViewById(R.id.ll);

        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    String dir = c.getString(c.getColumnIndex("Name"));
                    TextView tv = new TextView(Details.this);
                    tv.setText(dir);
                    ll.addView(tv);
                }while (c.moveToNext());
            }
        }
        // interest.execSQL("delete from skill_interest;");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //interest.execSQL("delete from skill_interest;");
                if(( ll).getChildCount() > 0)
                    ( ll).removeAllViews();
                course=skill.getText().toString();
                // Cursor d= courses.rawQuery("select url from cour where Name='"+course+"';",null);

                interest.execSQL("insert into skill_interest values('"+course+"');");
                Cursor c= interest.rawQuery("select distinct(Name) from skill_interest;",null);
                LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
                if (c != null ) {
                    if  (c.moveToFirst()) {
                        do {
                            String dir = c.getString(c.getColumnIndex("Name"));
                            TextView tv = new TextView(Details.this);
                            tv.setText(dir);
                            ll.addView(tv);
                        }while (c.moveToNext());
                    }
                }
                LinearLayout ll1=(LinearLayout)findViewById(R.id.ll1);
                Cursor ch= interest.rawQuery("select distinct(Name) from skill_interest;",null);
                if(( ll1).getChildCount() > 0)
                    ( ll1).removeAllViews();
                if (ch != null ) {

                    if  (ch.moveToFirst()) {
                        do {

                            String dir = ch.getString(ch.getColumnIndex("Name"));
                   // Cursor a=interest.rawQuery("select count(url) as co from cour where Name='"+dir+"';",null);
                   /* int var=0;
                    if(a.moveToFirst())
                    {
                        var=a.getInt(a.getColumnIndex("co"));
                    }
                    char vi=(char)(var+48);
                    String msg="We have found "+vi+"courses you may be interested in:";
                   TextView tv = new TextView(Details.this);
                    tv.setText(msg);
                    ll1.addView(tv);*/
                            Cursor dh=courses.rawQuery("select distinct(url) from cour where Name='"+dir+"';",null);
                            if(dh!=null)
                            {
                                if(dh.moveToFirst())
                                {
                                    do {
                                        String dr=dh.getString(dh.getColumnIndex("url"));
                                        TextView tv = new TextView(Details.this);
                                        tv.setText(dr);
                                        ll1.addView(tv);
                                    }while (dh.moveToNext());
                                }
                            }

                        }while (ch.moveToNext());
                    }
                }

            }
        });
    }

    private void createDb() {
        for(int i=0;i<5;i++)
            courses.execSQL("insert into cour values ('"+l[i]+"','"+s[i]+"');");
    }

}

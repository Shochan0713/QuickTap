package com.example.quicktap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreZone extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor edit;

    private int m;
    private int s;
    private int ms;

    private int m1;
    private int s1;
    private int ms1;

    private int m2;
    private int s2;
    private int ms2;

    private int m3;
    private int s3;
    private int ms3;

    private int m4;
    private int s4;
    private int ms4;

    private int m5;
    private int s5;
    private int ms5;

    private String score;
    private String score1;
    private String score2;
    private String score3;
    private String score4;
    private String score5;
//    private SharedPreferences.Editor edit = pref.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_zone);

        pref = getSharedPreferences("pref", MODE_PRIVATE);
        edit = pref.edit();

        Intent intent = getIntent();
        String score = intent.getStringExtra("score");

        TextView textTime = findViewById(R.id.textTime);
        TextView textNew = findViewById(R.id.textNew);
        TextView textScore = findViewById(R.id.textScore);
        TextView textHighScoreTime1 = findViewById(R.id.textHighScoreTime1);
        TextView textHighScoreTime2 = findViewById(R.id.textHighScoreTime2);
        TextView textHighScoreTime3 = findViewById(R.id.textHighScoreTime3);
        TextView textHighScoreTime4 = findViewById(R.id.textHighScoreTime4);
        TextView textHighScoreTime5 = findViewById(R.id.textHighScoreTime5);

        textTime.setText(score);
        // ハイスコアの時間を取得してセットする
        score1 = pref.getString("score1", "59:59:99");
        score2 = pref.getString("score2", "59:59:99");
        score3 = pref.getString("score3", "59:59:99");
        score4 = pref.getString("score4", "59:59:99");
        score5 = pref.getString("score5", "59:59:99");
        textHighScoreTime1.setText(score1);
        textHighScoreTime2.setText(score2);
        textHighScoreTime3.setText(score3);
        textHighScoreTime4.setText(score4);
        textHighScoreTime5.setText(score5);


        Button buttonHome = findViewById(R.id.buttonHome);
        Button buttonRetry = findViewById(R.id.buttonRetry);
        buttonHome.setOnClickListener(this);
        buttonRetry.setOnClickListener(this);

        m = Integer.parseInt(score.substring(0, 2));
        s = Integer.parseInt(score.substring(3, 5));
        ms = Integer.parseInt(score.substring(6, 8));

        m1 = Integer.parseInt(score.substring(0, 2));
        s1 = Integer.parseInt(score.substring(3, 5));
        ms1 = Integer.parseInt(score.substring(6, 8));

        m2 = Integer.parseInt(score2.substring(0, 2));
        s2 = Integer.parseInt(score2.substring(3, 5));
        ms2 = Integer.parseInt(score2.substring(6, 8));

        m3 = Integer.parseInt(score3.substring(0, 2));
        s3 = Integer.parseInt(score3.substring(3, 5));
        ms3 = Integer.parseInt(score3.substring(6, 8));

        m4 = Integer.parseInt(score4.substring(0, 2));
        s4 = Integer.parseInt(score4.substring(3, 5));
        ms4 = Integer.parseInt(score4.substring(6, 8));

        m5 = Integer.parseInt(score5.substring(0, 2));
        s5 = Integer.parseInt(score5.substring(3, 5));
        ms5 = Integer.parseInt(score5.substring(6, 8));

        if (m < m1) {
            edit.putString("score1", score);
            edit.putString("score2", score1);
            edit.putString("score3", score2);
            edit.putString("score4", score3);
            edit.putString("score5", score4);
            edit.commit();
        } else if (m == m1) {
            if (s < s1) {
                edit.putString("score1", score);
                edit.putString("score2", score1);
                edit.putString("score3", score2);
                edit.putString("score4", score3);
                edit.putString("score5", score4);
                edit.commit();
            } else if (s == s1) {
                if (ms < ms1) {
                    edit.putString("score1", score);
                    edit.putString("score2", score1);
                    edit.putString("score3", score2);
                    edit.putString("score4", score3);
                    edit.putString("score5", score4);
                    edit.commit();
                } else if (ms >= ms1) {
                    score2check();
                }
            } else if (s > s1) {
                score2check();
            }
        } else if (m > m1) {
            score2check();
        }
    }


    private void score2check() {
            if (m < m2) {
                edit.putString("score2", score);
                edit.putString("score3", score2);
                edit.putString("score4", score3);
                edit.putString("score5", score4);
                edit.commit();
            } else if (m == m2) {
                if (s < s2) {
                    edit.putString("score2", score);
                    edit.putString("score3", score2);
                    edit.putString("score4", score3);
                    edit.putString("score5", score4);
                    edit.commit();
                } else if (s == s2) {
                    if (ms < ms2) {
                        edit.putString("score2", score);
                        edit.putString("score3", score2);
                        edit.putString("score4", score3);
                        edit.putString("score5", score4);
                        edit.commit();
                    } else if (ms >= ms2) {
                        score3check();
                    }
                } else if (s > s2) {
                    score3check();
                }
            } else if (m > ms2) {
                score3check();
            }
        }




    private void score3check () {
            if (m < m3) {
                edit.putString("score3", score2);
                edit.putString("score4", score3);
                edit.putString("score5", score4);
                edit.commit();
            } else if (m == m3) {
                if (s < s3) {
                    edit.putString("score3", score2);
                    edit.putString("score4", score3);
                    edit.putString("score5", score4);
                    edit.commit();
                } else if (s == s3) {
                    if (ms < ms3) {
                        edit.putString("score3", score2);
                        edit.putString("score4", score3);
                        edit.putString("score5", score4);
                        edit.commit();
                    } else if (ms >= ms3) {
                        score4check();
                    }
                } else if (s > s3) {
                    score4check();
                }
            } else if (m > ms3) {
                score4check();
            }
        }

        private void score4check () {
            if (m < m4) {
                edit.putString("score4", score);
                edit.putString("score5", score4);
                edit.commit();
            } else if (m == m4) {
                if (s < s4) {
                    edit.putString("score4", score);
                    edit.putString("score5", score4);
                    edit.commit();
                } else if (s == s4) {
                    if (ms < ms4) {
                        edit.putString("score4", score);
                        edit.putString("score5", score4);
                        edit.commit();
                    } else if (ms >= ms4) {
                        score5check();
                    }
                } else if (s > s4) {
                    score5check();
                }
            } else if (m > ms4) {
                score5check();
            }
        }

        private void score5check () {
            if (m < m5) {
                edit.putString("score1", score1);
                edit.commit();
            } else if (m == m5) {
                if (s < s5) {
                    edit.putString("score1", score1);
                    edit.commit();
                } else if (s == s5) {
                    if (ms < ms5) {
                        edit.putString("score1", score1);
                        edit.commit();
                    }
                }
            }
        }





    @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.buttonHome:
                    Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentHome);
                    break;
                case R.id.buttonRetry:
                    Intent intentRetry = new Intent(getApplicationContext(), GameAction3.class);
                    startActivity(intentRetry);
                    break;
            }
        }
    }



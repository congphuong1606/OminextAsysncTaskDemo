package asynctask.android.vn.demoasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MyPC on 28/06/2017.
 */

public class MyAsyncTask extends AsyncTask<Void,Integer,Void>{


    Activity context;



    public MyAsyncTask(Activity context) {
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context,"bắt đầu chạy -onPreExecute",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i=1;i<=100;i++){
            SystemClock.sleep(300);
            publishProgress(i);
        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int number=values[0];
        ProgressBar prbDemo=(ProgressBar)context.findViewById(R.id.prb_demo);
        prbDemo.setProgress(number);
        TextView tvStatus=(TextView)context.findViewById(R.id.tv_status);
        tvStatus.setText(number+"%");
    }


    @Override
    protected void onPostExecute(Void o) {
        super.onPostExecute(o);
        Toast.makeText(context,"đã xong - onpostExecute",Toast.LENGTH_SHORT).show();
    }
}

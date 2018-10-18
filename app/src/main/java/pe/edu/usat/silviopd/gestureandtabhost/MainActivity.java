package pe.edu.usat.silviopd.gestureandtabhost;


import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    TextView txtMessages;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessages = (TextView) findViewById(R.id.txtMessages);
        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

    }

    /*GestureDetector.OnGestureListener*/
    @Override
    public boolean onDown(MotionEvent e) {
        txtMessages.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        txtMessages.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        txtMessages.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float distanceScrollX = e2.getX() - e1.getX();
        float distanceScrollY = e2.getY() - e1.getY();

        if (Math.abs(distanceScrollY) > Math.abs(distanceScrollX)) {
            if (distanceScrollY < 0) {
                txtMessages.setText("onScroll Up");
            } else {
                txtMessages.setText("onScroll Down");
            }
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

        txtMessages.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float distanceFlingX = e2.getX() - e1.getX();
        float distanceFlingY = e2.getY() - e1.getY();

        if (Math.abs(distanceFlingX) > Math.abs(distanceFlingY)) {
            if (distanceFlingX > 0) {
                txtMessages.setText("onFling Rigt");
            } else {
                txtMessages.setText("onFling Left");
            }
        }

        return true;
    }
    /*GestureDetector.OnGestureListener*/

    /*GestureDetector.OnDoubleTapListener*/
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {

        txtMessages.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        txtMessages.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        txtMessages.setText("onDoubleTapEvent");
        return true;
    }
    /*GestureDetector.OnDoubleTapListener*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

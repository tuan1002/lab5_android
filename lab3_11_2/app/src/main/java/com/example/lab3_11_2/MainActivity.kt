package com.example.lab3_11_2

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    private lateinit var gestureDetector: GestureDetectorCompat
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.mainLayout) // Đảm bảo layout này đã có ID trong XML
        gestureDetector = GestureDetectorCompat(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return event?.let { gestureDetector.onTouchEvent(it) } == true || super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Không cần xử lý
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        layout.setBackgroundColor(Color.BLUE) // Chạm 1 lần đổi nền thành màu xanh
        Toast.makeText(this, "Tap detected!", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        p1: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        // Phân biệt vuốt lên và vuốt xuống
        if (e1 != null && e2 != null) {
            if (e1.y < e2.y) {
                layout.setBackgroundColor(Color.RED) // Vuốt xuống đổi nền thành màu đỏ
                Toast.makeText(this, "Swipe Down detected!", Toast.LENGTH_SHORT).show()
            } else if (e1.y > e2.y) {
                layout.setBackgroundColor(Color.YELLOW) // Vuốt lên đổi nền thành màu vàng
                Toast.makeText(this, "Swipe Up detected!", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Toast.makeText(this, "Long press detected!", Toast.LENGTH_SHORT).show()
    }
}

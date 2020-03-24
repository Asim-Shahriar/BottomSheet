package com.example.bottomsheet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {
  private RecyclerView recyclerview;
  private int[] images={R.drawable.car_ex,R.drawable.car_black,R.drawable.car_jeep,R.drawable.car_red,R.drawable.car_yellow};
  private RecyclerView.LayoutManager layoutManager;
  private RecyclerAdapter adapter;
  BottomSheetBehavior behavior;
  ConstraintLayout constraintLayout;
  Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        btn=findViewById(R.id.btn_main);
        recyclerview=findViewById(R.id.bottomsheet_recyclerview);
        View bottomSheet=findViewById(R.id.layout_bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        constraintLayout=findViewById(R.id.constraintLayout_main);
        layoutManager=new LinearLayoutManager(this);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(images);
        recyclerview.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(behavior.getState()!=BottomSheetBehavior.STATE_EXPANDED){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    btn.setText("Close sheet");
                }else{
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    btn.setText("Expand sheet");
                }
            }
        });

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch(i){
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        btn.setText("close sheet");
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        btn.setText("Expand Sheet");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }
}

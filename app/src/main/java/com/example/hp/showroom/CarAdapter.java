package com.example.hp.showroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private List<Car> carList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView priceCar, nameCar;
    //    public ImageView imageCar;

        public MyViewHolder(View view) {
            super(view);
        //    imageCar = (ImageView) view.findViewById(R.id.imageCar);
            nameCar = (TextView) view.findViewById(R.id.nameCar);
            priceCar = (TextView) view.findViewById(R.id.priceCar);
        }
    }


    public CarAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Car car = carList.get(position);
        //holder.imageCar.setImageResource(car.getImage());
        holder.nameCar.setText(car.getCarname());
        holder.priceCar.setText(car.getPrice());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
}
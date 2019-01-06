package iitg.shubham.servall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class UserAdapter1 extends RecyclerView.Adapter<UserAdapter1.UserViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<User1> userList;

    //getting the context and product list with constructor
    public UserAdapter1(Context mCtx, List<User1> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }
 
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_help, null);
        return new UserViewHolder(view);
    }
 
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        //getting the product of the specified position
        User1 user= userList.get(position);

        
        //binding the data with the viewholder views
        holder.textViewTitle1.setText(user.getTitle());
        holder.textViewShortDesc1.setText(user.getShortdesc());
        holder.textViewRating1.setText(String.valueOf(user.getRating()));
        holder.textViewPrice1.setText(String.valueOf(user.getPrice()));
        
        holder.imageView1.setImageDrawable(mCtx.getResources().getDrawable(user.getImage()));
        
    }
 
    
    @Override
    public int getItemCount() {
        return userList.size();
    }
 
    
    class UserViewHolder extends RecyclerView.ViewHolder {
 
        TextView textViewTitle1, textViewShortDesc1, textViewRating1, textViewPrice1;
        ImageView imageView1;
 
        public UserViewHolder(View itemView) {
            super(itemView);
 
            textViewTitle1 = itemView.findViewById(R.id.textViewTitle1);
            textViewShortDesc1 = itemView.findViewById(R.id.textViewShortDesc1);
            textViewRating1 = itemView.findViewById(R.id.textViewRating1);
            textViewPrice1 = itemView.findViewById(R.id.textViewPrice1);
            imageView1 = itemView.findViewById(R.id.imageView1);
        }
    }
}
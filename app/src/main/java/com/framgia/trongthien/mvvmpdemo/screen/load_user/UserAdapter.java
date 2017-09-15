package com.framgia.trongthien.mvvmpdemo.screen.load_user;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.framgia.trongthien.mvvmpdemo.R;
import com.framgia.trongthien.mvvmpdemo.data.model.User;
import com.framgia.trongthien.mvvmpdemo.databinding.ItemUserBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrongThien on 9/15/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> users = new ArrayList<>();
    private LayoutInflater inflater;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    public void loadListUser(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_user, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.binding(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding binding;

        public UserViewHolder(ItemUserBinding binding) {
            super(binding.itemPeople);
            this.binding = binding;
        }

        public void binding(User user) {
            binding.setItemUserModelView(new ItemUserViewModel(user));
            binding.executePendingBindings();
        }
    }
}

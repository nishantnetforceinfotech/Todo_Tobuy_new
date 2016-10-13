package com.netforceinfotech.todo_tobuy.DashBoard.Main_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netforceinfotech.todo_tobuy.DashBoard.To_Buy_Group_Fragment.Group_Fragment_tobuy;
import com.netforceinfotech.todo_tobuy.DashBoard.grid.helper.OnStartDragListener;
import com.netforceinfotech.todo_tobuy.DashBoard.grid.helper.SimpleItemTouchHelperCallback;
import com.netforceinfotech.todo_tobuy.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_main#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_main extends Fragment implements OnStartDragListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rl_view;
    GridLayoutManager gridLayoutManager;
    Fragment_main_grid_adapter main_grid_adapter;
    private ItemTouchHelper mItemTouchHelper;
    ArrayList<String> list = new ArrayList<>();
    public Fragment_main() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_main.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_main newInstance(String param1, String param2) {
        Fragment_main fragment = new Fragment_main();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rl_view = (RecyclerView) view.findViewById(R.id.RecyclerView_main);

        for(int i=1;i<19;i++){

            list.add(i+"");
        }
        main_grid_adapter = new Fragment_main_grid_adapter(getActivity(),
                getActivity().getSupportFragmentManager(),this,list);

        rl_view.setLayoutManager(gridLayoutManager);
        rl_view.setAdapter(main_grid_adapter);
        // Inflate the layout for this fragment

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(main_grid_adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rl_view);

        ((TextView) view.findViewById(R.id.new_group)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Group_Fragment_tobuy f = new Group_Fragment_tobuy();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main, f, "Group_Fragment_tobuy")
                        .addToBackStack("Group_Fragment_tobuy")
                        .commit();

            }
        });

        ((ImageView)view.findViewById(R.id.new_group_img)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Group_Fragment_tobuy f = new Group_Fragment_tobuy();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main, f, "Group_Fragment_tobuy")
                        .addToBackStack("Group_Fragment_tobuy")
                        .commit();

            }
        });

        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        //  mItemTouchHelper.startDrag(viewHolder);
        Log.e("hhh", "test");
    }
}

package com.deng.buildmaterialbuyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabContentFragment extends Fragment {

    private static final String EXTRA_CONTENT = "content";
    ListView tv;

    public static TabContentFragment newInstance(String content){
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, content);
        TabContentFragment tabContentFragment = new TabContentFragment();
        tabContentFragment.setArguments(arguments);
        return tabContentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_tab_content, null);
        //((TextView)contentView.findViewById(R.id.tv_content)).setText(getArguments().getString(EXTRA_CONTENT));
        String  sName = getArguments().getString(EXTRA_CONTENT);
        tv = (ListView)contentView.findViewById(R.id.myList);
        FillListView(tv,sName);
        tv.setOnItemClickListener(new ItemClicked());


        return contentView;
    }

    //判断选择打开新的页面
    class ItemClicked implements ListView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String text = tv.getItemAtPosition(i).toString();
            //Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
            switch (text)
            {
                case "工字钢规格表":
                case "槽钢规格表":
                case "角钢规格表":
                    Intent intent = new Intent(getActivity(), HtmlActivity.class);
                    intent.putExtra("page",text);
                    startActivity(intent);
                    break;
            }


        }
    }

    public void FillListView(ListView tv,String sName)
    {
        //根据TLayout的选择对ListView进行对应的填充
        ListView listview = tv;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1);
        switch (sName)
        {
            case "材料计算器":
                adapter.add("圆钢管计算器");
                adapter.add("方钢管计算器");
                adapter.add("砂石收方计算");
                break;
            case "采购要点":
                adapter.add("钢厂标记");
                adapter.add("砖规格型号");
                adapter.add("砂石规格型号");
                break;
            case "采购资料":
                adapter.add("工字钢规格表");
                adapter.add("槽钢规格表");
                adapter.add("角钢规格表");
                break;
        }

        listview.setAdapter(adapter);

    }

}

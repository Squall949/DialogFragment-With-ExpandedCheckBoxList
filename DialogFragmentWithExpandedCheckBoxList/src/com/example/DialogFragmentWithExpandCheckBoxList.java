package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;


public class DialogFragmentWithExpandCheckBoxList extends DialogFragment {

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    View view = getActivity().getLayoutInflater().inflate(R.layout.expanded_checkboxlist, null);
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    
    this.createContent(view); //set up Expandable CheckBoxList items
    builder.setTitle("ExpandedCheckBoxList").setView(view);
    return builder.create();
  }
  
  private void createContent(View view){
    String[] top250 = {"The Shawshank Redemption","The Godfather","Pulp Fiction","The Good, the Bad and the Ugly","The Dark Knight"};
    String[] nowShowing = {"The Conjuring","Despicable Me 2","Turbo","Grown Ups 2","Red 2","The Wolverine"};
    String[] comingSoon = {"2 Guns","The Smurfs 2","The Spectacular Now","The Canyons","Europa Report"};
    ArrayList<HashMap<String,String>> groupitems = new ArrayList<HashMap<String,String>>();
    HashMap<String,String> groupItem = new HashMap<String,String>();
    ArrayList<ArrayList<HashMap<String,String>>> childitems = new ArrayList<ArrayList<HashMap<String,String>>>();
    ArrayList<HashMap<String,String>> childList = new ArrayList<HashMap<String,String>>();
    
    groupItem.put("GroupItem", "Top 250");
    groupitems.add(groupItem);
    
    for (String text : top250) {
      HashMap<String,String> childItem = new HashMap<String,String>();
      childItem.put("SubItemTxt", text);
      childList.add(childItem);
    }
    childitems.add(childList);
    
    groupItem = new HashMap<String,String>();
    groupItem.put("GroupItem", "Now Showing");
    groupitems.add(groupItem);
    childList = new ArrayList<HashMap<String,String>>();
    for (String text : nowShowing) {
      HashMap<String,String> childItem = new HashMap<String,String>();
      childItem.put("SubItemTxt", text);
      childList.add(childItem);
    }
    childitems.add(childList);
    
    groupItem = new HashMap<String,String>();
    groupItem.put("GroupItem", "Coming Soon...");
    groupitems.add(groupItem);
    childList = new ArrayList<HashMap<String,String>>();
    for (String text : comingSoon) {
      HashMap<String,String> childItem = new HashMap<String,String>();
      childItem.put("SubItemTxt", text);
      childList.add(childItem);
    }
    childitems.add(childList);
    
    cusSimpExpListAdapter expListAdapter =
        new cusSimpExpListAdapter(
            getActivity(),
            groupitems,                     
            R.layout.group_item_ex1,            
            new String[] { "GroupItem" },  
            new int[] { R.id.textView1_group_item_ex1 },   
            childitems,              
            R.layout.child_item_ex1,            
            new String[] {"SubItemTxt"},    
            new int[] { R.id.checkBox1_child_item_ex1}   
        );
    
    ExpandableListView elst = (ExpandableListView) view.findViewById(R.id.expandableListView1_example1);
    elst.setAdapter(expListAdapter);
    for (int i=0;i<groupitems.size();i++){
      elst.expandGroup(i);
    }
  }
  
  class cusSimpExpListAdapter extends SimpleExpandableListAdapter{

    private ArrayList<ArrayList<HashMap<String,String>>> childData;
    public cusSimpExpListAdapter(Context context, List<? extends Map<String, ?>> groupData, int groupLayout, String[] groupFrom, int[] groupTo,
        List<? extends List<? extends Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo)
    {
      super(context, groupData, groupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
      // TODO Auto-generated constructor stub
      this.childData=(ArrayList<ArrayList<HashMap<String, String>>>) childData;
    }
    
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
      return true;
    }
    
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
      
      if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.child_item_ex1, null);
      }
      
      CheckBox chk = (CheckBox) convertView.findViewById(R.id.checkBox1_child_item_ex1);
      chk.setText(childData.get(groupPosition).get(childPosition).get("SubItemTxt"));
      
      return convertView;
    }
  }
}
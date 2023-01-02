import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.json.JsonMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.xdevapi.JsonArray;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.text.ParseException;  
import com.fasterxml.jackson.core.JsonFactory;  
import com.fasterxml.jackson.core.JsonParseException;  
import com.fasterxml.jackson.core.JsonParser;  
import com.fasterxml.jackson.databind.JsonMappingException;  
import com.fasterxml.jackson.databind.JsonNode;  
import com.fasterxml.jackson.databind.ObjectMapper;  
import io.netty.util.internal.ThreadLocalRandom;


public class Nallas_demo 
{

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	
	public static String[] choices = { "From json file","Direct json content"};
	public static String[] type = { "Excel ","CSV"};

	public static JComboBox<String> input_option = new JComboBox<String>(choices);
	public static JComboBox<String> outputfile_type = new JComboBox<String>(type);
	public static String user_status ="Yet to start";
	public static  String  Verification="";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static JTextField userEnt1;
	public static JTextField primarykey;
	public static  String  input_json1="";
	public static  String  input_json2="";
	public static  String  input_typevalue="";
	public static  String  outpur_typevalue="";
	public static  String filelocation;
	public static int length;
	public static  int count;  
	public static Integer [] int_array;
	public static JButton number;
	public static JButton reset;
	public static String finalvalue="empty";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static ArrayList<String> Finaljsoncomparison = new ArrayList<String>();
	public static ArrayList<String> json1keylist= new ArrayList<String>();
	public static ArrayList<String> json2keylist= new ArrayList<String>();
	public static Multimap<String, String[][]> map1 = ArrayListMultimap.create();
	public static Multimap<String, String[][]> map2 = ArrayListMultimap.create();
	public static String [][][] Json2array;
	public static List<String> Primarykeyvalue = new ArrayList<String>();
	public static List<String> final_output = new ArrayList<String>();
	public static String file_content;
	public static String file_content1;
	public static String primary_key="";
	public static Boolean status = false;
	public static Boolean filestatus = true;
	@SuppressWarnings("rawtypes")
	Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();
	public static ArrayList<String> keylist1= new ArrayList<String>();
	public static ArrayList<String> keylist2= new ArrayList<String>();
	
	public static void main(String[] args) 
	{
					
     try
     {

    	 final JFrame frame = new JFrame();
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setTitle("-----Welcome to NALLAS-----");
 		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
 		

 		//---to identify system resolution----
 		int[] scrn_resln = system_resolution();
 	    int width = scrn_resln[0];
 		 int height = scrn_resln[1];
 		 frame.setSize(width/2,height/2);
 		//---Element initialization----
 		JPanel LeftPanelY = new JPanel();
 		LeftPanelY.setLayout(new BoxLayout(LeftPanelY, BoxLayout.Y_AXIS));
 		
 		JLabel list_labeldrpdown = new JLabel("Select Input Type");
 		JLabel list_labeldrpdown1 = new JLabel("Select Ouput File Type");
 		 JLabel list_label = new JLabel("Json1 File location/Content");
 		JLabel list_label1 = new JLabel("Json2 File location/Content");
 		JLabel list_label3 = new JLabel("Primaty Key");
 		JLabel list_label2 = new JLabel(" ");
          userEnt = new JTextField("", 10);
          userEnt1 = new JTextField("", 10);
          primarykey = new JTextField("", 10);
            number = new JButton("Validate");
           reset = new JButton("Reset");
          Set1 ="Yet to Start";
          Set_list1  = new JLabel("<html><br>"+"Status**"+Set1+" --**</html>");
          
          LeftPanelY.add(list_labeldrpdown);
          LeftPanelY.add(input_option);
          
          LeftPanelY.add(list_label2);
         
          LeftPanelY.add(list_label);
          LeftPanelY.add(userEnt);
          
          LeftPanelY.add(list_label2);
          
          LeftPanelY.add(list_label1);
          LeftPanelY.add(userEnt1);
          
          LeftPanelY.add(list_label2);
          
          LeftPanelY.add(list_label3);
          LeftPanelY.add(primarykey);
          
          LeftPanelY.add(list_label2);
          LeftPanelY.add(list_labeldrpdown1);
          LeftPanelY.add(outputfile_type);
          
          LeftPanelY.add(list_label2);
          
          
          
          LeftPanelY.add(number);
          
          LeftPanelY.add(list_label2);
          LeftPanelY.add(reset);
          LeftPanelY.add(Set_list1);
          LeftPanelY.setPreferredSize(new Dimension(500, 500));
          LeftPanelY.setMaximumSize(new Dimension(500, 500));
          LeftPanelY.setAlignmentX(Component.CENTER_ALIGNMENT);
          frame.getContentPane().add(LeftPanelY);
          //frame.setSize(550, 300);
          frame.setVisible(true);
          //frame.add(pane1);
          //frame.setVisible(true);
         
           number.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  reset.setEnabled(true);
 				  userEnt.setEditable(false);
 				 userEnt1.setEditable(false);
 				  number.setEnabled(false);
 				 primarykey.setEnabled(false);
 				 input_json1 = userEnt.getText();
 				 input_json2 = userEnt1.getText();
 				primary_key = primarykey.getText();
 				input_typevalue = input_option.getSelectedItem().toString();
 				outpur_typevalue = outputfile_type.getSelectedItem().toString();
 				System.out.println("test"+input_typevalue);
 				 Verification ="";
 				filestatus = true;
 				final_output.clear();
 				keylist1.clear();
 				keylist2.clear();
 				map1.clear();
 				map2.clear();
 				
 				System.out.println(final_output.size());
 				 //System.out.println("print" + finalstring +finalstring1 );
 				
 				
 				 if(!input_json1.equals("") && !input_json2.equals("") && !primary_key.equals(""))
 				 {
 					if(input_typevalue.equalsIgnoreCase("From json file")) 
 					{	
								Boolean filecheck_status;
								try {
									filecheck_status = checkinput_file(input_json1,input_json2);
									if (filecheck_status == false)
									{
										Verification = "Given File is not exist. Please check the file location";
										Set_list1.setText("<html><br>"+"Json comparison status"+ Verification+" --**</html>");
									}
								} 
								catch (IOException e1) 
								{
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}	
 					}
 					else
 					{	
 						file_content = input_json1;
 						file_content1 = input_json2;
 					}
 				if(filestatus!=false)
 				{
 					//JSONObject json = new JSONObject(file_content);  
 					try {
 						
 						try {
 						JSONObject json = new JSONObject(file_content);
 						
 						JSONObject json1 = new JSONObject(file_content1);
 						Stringformation_array(json,map1);
 						Stringformation_array(json1,map2);
 						arraycompare(map1,map2,keylist1);
 						addkey_list(map1,keylist1);
	 						addkey_list(map2,keylist2);
	 						key_compare(keylist1,keylist2);
	 						writefile();
 						}
 						catch(Exception e1)
 						{
 							System.out.println(e1.toString());
 							JSONArray jsonArr1 = new JSONArray(file_content);
 							JSONArray jsonArr2 = new JSONArray(file_content1);
 							formation_array(jsonArr1,map1);
 	 						formation_array(jsonArr2,map2);
 	 						arraycompare(map1,map2,keylist1);
 	 						addkey_list(map1,keylist1);
 	 						addkey_list(map2,keylist2);
 	 						key_compare(keylist1,keylist2);
 	 						writefile();
 						}
					} 
 					catch (Exception e1) 
 					{
						// TODO Auto-generated catch block
						Verification = "--Check your input data. It is not a valid data.--";
		 				Set_list1.setText("<html><br>"+" Json comparison status "+ Verification+" --**</html>");	
					}
 				 }
 				
 				 int size = final_output.size();
 				 System.out.println("list size"+size);
 		if(size>1)
 		{
 			Verification = "--completed--";
				Set_list1.setText("<html><br>"+" Json comparison status "+ Verification+" --**</html>");
 				
				JOptionPane.showMessageDialog(null,filelocation, "Output Generated: File Location ", JOptionPane.PLAIN_MESSAGE);
 		
 		}
 		else if(size==1)
 		{
 			JOptionPane.showMessageDialog(null,"There is no difference in JSON. Both are same", "Output Json Comparison: Status ", JOptionPane.PLAIN_MESSAGE);
 		}
 		else if(size==0)
 		{
 			JOptionPane.showMessageDialog(null,"Check your input json. Its not valid", "Output Json Comparison: Status ", JOptionPane.PLAIN_MESSAGE);
 		}
 		}
 				 else
 				 {
 					 if(filestatus==false)
 					 {
 					Verification = "Given File is not exist. Please check the file location";
					Set_list1.setText("<html><br>"+"Json comparison status"+ Verification+" --**</html>");
 					 }
 					 else
 					 {
 					Verification = "--Required input cannot be blank--";
	 				Set_list1.setText("<html><br>"+" Json comparison status "+ Verification+" --**</html>");	
 					 }
 				 }
 			  }});  

           
          reset.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				 input_option.setSelectedIndex(0);
 				outputfile_type.setSelectedIndex(0);
 				  number.setEnabled(true);
 				  userEnt.setEditable(true);
 				  userEnt.setText("");
 				 userEnt1.setEditable(true);
				  userEnt1.setText("");
				  primarykey.setEnabled(true);
				  primarykey.setText("");
 				  reset.setEnabled(false);
 				 Set1 = "Reset Completed";
 				final_output.clear();
					Set_list1.setText("<html><br>"+"Json comparison status:"+ Set1+" --**</html>");
 				  
 			  }});
          
          
	}
	catch(Exception g)
	{
		System.out.println(g.toString());
	}
	}
 	
     
     
     public static boolean checkinput_file(String file_val1, String file_val2) throws IOException
     {
    		
			File jsoninput1 = new File(file_val1);
			File jsoninput2 = new File(file_val2);
         
			boolean exists = jsoninput1.exists();
			boolean exists1 = jsoninput1.exists();
			
			//true
      if(exists==true&& exists1==true)
      {
		
		System.out.println(jsoninput1.getName());
		System.out.println(jsoninput2.getName());
		String extension1 = FilenameUtils.getExtension(jsoninput1.getName());
		String extension2 = FilenameUtils.getExtension(jsoninput2.getName());
		
	     
	     @SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file_val1));
	     file_content = reader.readLine();
	     
	     @SuppressWarnings("resource")
		BufferedReader reader1 = new BufferedReader(new FileReader(file_val2));
	     file_content1 = reader1.readLine();
	     filestatus = true;
		}
		else
		{
			filestatus = false;
			Verification = "Given File is not exist. Please check the file location";
			Set_list1.setText("<html><br>"+"Json comparison status"+ Verification+" --**</html>");
		}
      return filestatus;
	 
     }
     
     @SuppressWarnings({ "deprecation" })
	public static Map<String, String> comparejson(JSONObject json, Map<String,String> myMap) throws IOException
     {
    	 int curLen =  json.length();
    		    Iterator<String> keys;
    		    if(curLen>1) {
    		    	keys = json.keys();
    		        while(keys.hasNext()){
    		            String nextKeys = keys.next();
    		            try 
    		            {
    		                if(json.get(nextKeys) instanceof  JSONObject)
    		                {
    		                	if(curLen>1) 
    		                    {
    		                		comparejson(json.getJSONObject(nextKeys),myMap);
    		                    }
    		                    }
    		                else{
    		                    System.out.println(nextKeys);
    		                    Object ansKey =  json.get(nextKeys);
    		                    myMap.put(nextKeys,ansKey.toString());
    		                }
    		            }
    		            catch (Exception e) {
    		            	System.out.println(false);
    		            }
    		        }
    		    }
    		    else if(curLen == 1) {
    		      ///  System.out.println(json.toString());
    		        Object ansKey =  json.get(json.toString());
    		        myMap.put(json.toString(),ansKey.toString());
    		    }
    		    return myMap;
    		}
	
     
  
   
     public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException
     {
    	    Iterator<String> keys = json.keys();
    	    while(keys.hasNext()){
    	        String key = keys.next();
    	        String val = null;
    	if ( json.getJSONObject(key) instanceof JSONObject ) {
    	    JSONObject value = json.getJSONObject(key);
    	    parse(value,out);
    	} 

    	else {
    	     val = json.getString(key);
    	}


    	        if(val != null){
    	            out.put(key,val);
    	        }
    	    }
    	    return out;
    	}
    	
     
     
     
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
	
public static String read_jsonfile(String filelocation) throws IOException
{
        return new String(Files.readAllBytes(Paths.get(filelocation)));
}


public static void Stringformation_array(JSONObject obj, Multimap<String, String[][]> map)
{
	
	 Iterator<String> iterator = obj.keys();
	   
	    while (iterator.hasNext()) 
	    {
	       String key1 = (String) iterator.next();
	        System.out.println(key1);
	        
	        if(file_content.contains("["))
	        {
	        	
	        JSONArray jsonarray = (JSONArray) obj.get(key1);
	        
	        for (Object obj_list : jsonarray) 
	        {
	        	
	            JSONObject jsonLineItem = (JSONObject) obj_list;
	            String val_primarykey = jsonLineItem.getString(primary_key);
	            Primarykeyvalue.add(val_primarykey);
	            
	            Iterator<String> iterator1 = jsonLineItem.keys();
	            int a=0;
	            while (iterator1.hasNext()) 
	            {
	            	String key3 = (String) iterator1.next();
	            	String val = jsonLineItem.getString(key3);
	            //	System.out.println(key3+" "+val);
	            	map.put(val_primarykey,new String[][] {{key3,val}});
	            }
	        }
	        }
	        else
	        {
	        	
	        	while (iterator.hasNext()) 
	            {
	 	            String val_primarykey = obj.getString(primary_key);
	 	            Primarykeyvalue.add(val_primarykey);
	 	            String key2 = (String) iterator.next();
	            	
	            	String val = obj.getString(key2);
	          //  	System.out.println(key2+" "+val);
	            	map.put(val_primarykey,new String[][] {{key2,val}});
	            }
	 	        
	        }
	    }
}

public static void formation_array(JSONArray obj, Multimap<String, String[][]> map)
{
	
	 
	 for (Object obj_list : obj) 
     {
     	
         JSONObject jsonLineItem = (JSONObject) obj_list;
         String val_primarykey = jsonLineItem.getString(primary_key);
         Primarykeyvalue.add(val_primarykey);
         
         Iterator<String> iterator1 = jsonLineItem.keys();
         int a=0;
         while (iterator1.hasNext()) 
         {
         	
         	String key3 = (String) iterator1.next();
         	
         	String val = jsonLineItem.getString(key3);
         	//System.out.println(key3+" "+val);
         	map.put(val_primarykey,new String[][] {{key3,val}});
         	 
         }
        
     }
}


public static void arraycompare(Multimap<String, String[][]> jsonmap1,Multimap<String, String[][]> jsonmap2,ArrayList<String> list )
{
	Iterator<Map.Entry<String, String[][]>> itr = jsonmap1.entries().iterator();
	final_output.add("MISSMATCH SUMMARY");
	    while(itr.hasNext())
           {
          Map.Entry<String, String[][]> entry = itr.next();
          String key1 = entry.getKey();
          String[][] vl = entry.getValue();
          String ll = vl[0][0];
          String ll1 = vl[0][1];
          Iterator<Map.Entry<String, String[][]>> itr1 = jsonmap2.entries().iterator();
          
          while(itr1.hasNext())
          {
        	  Map.Entry<String, String[][]> entry1 = itr1.next();
        	  String key2 = entry1.getKey();
        	  if(key1.equals(key2))
        	  {
        		  String[][] arlst = entry1.getValue();
        		  String arlst1 = arlst[0][0];
        		  String arlst2 = arlst[0][1];
        		  if(ll.equals(arlst1))
        		  {
        			 // System.out.println("Keymatched"+"keyvalue"+ll);
        			  if(arlst2.equals(ll1))
            		  {
            			 // System.out.println("Final----- Primary Key:" +key1 + ": "+ arlst1+"- "+ arlst2);
            		  }
        			  else
            		  {
        				  String val = primary_key+": "+ key2+ " Mismatch value--"+ ll1+"/"+arlst2;
        				  final_output.add(val);
            			  System.out.println(val);
            		  }
            		 
        		  }
        		  else
        		  {
        			 continue;
        		  }
        		  
        		  
        	  }
          }
           }

	        }

	    
	public static void addkey_list(Multimap<String, String[][]> jsonmap1,ArrayList<String> list)
	{
		Iterator<Map.Entry<String, String[][]>> itr = jsonmap1.entries().iterator();
		
	    while(itr.hasNext())
           {
          Map.Entry<String, String[][]> entry = itr.next();
          String key1 = entry.getKey();
          list.add(key1);
           }
	}
	
	
	public static void key_compare(ArrayList<String> list,ArrayList<String> list1)
	{
		
		Set<String> A = new HashSet<>(list);
		Set<String> B = new HashSet<>(list1);

		Set<String> copyA = new HashSet<>(A);
		Set<String> copyB = new HashSet<>(B);

		copyB.removeAll(A);
		
		Boolean copyB_status = copyB.isEmpty();
		if(copyB_status==false)
		{
			System.out.println("Record missing in JSON 1: " + copyB);
			String json2_status = "Record missing in JSON 1: " + copyB;
			 final_output.add(json2_status);

		}
		copyA.removeAll(B);
		Boolean copyA_status = copyA.isEmpty();
		if(copyA_status==false)
		{
			String json1_status = "Record missing in JSON 2: " + copyA;
			final_output.add(json1_status);
		}
		
	}

 public static void keyvaluecomparator(String key, String value, JSONArray jsonarry)
 
 {
	 
	 
	 for (Object obj_list : jsonarry) 
     {
     
	  JSONObject jsonLineItem = (JSONObject) obj_list;
      Iterator<String> iterator1 = jsonLineItem.keys();
      while (iterator1.hasNext()) 
      {
      	String key1 = (String) iterator1.next();
      	if(status==false)
      	{
      	 json1keylist.add(key1);
      	}
      	String val = jsonLineItem.getString(key1);
      	 System.out.println("key:"+ key1+ "value"+val);
        if(key1.equalsIgnoreCase(key))
        {
        	if(val.equals(value))
        	{
        		
        		String status = "Matched";
        		String finalstr = "Key :"+key+" Value from json1 :"+ value+ " Value from json2 :"+ val+ " Status :" + status;
        		System.out.println(finalstr);
        		Finaljsoncomparison.add(finalstr);
        		
        	}
        	else
        	{
        		String status = "Not match";
        		String finalstr = "Key :"+key+" Value from json1 :"+ value+ " Value from json2 :"+ val+ " Status :" + status;
        		System.out.println(finalstr);
        		Finaljsoncomparison.add(finalstr);
        	}
        	
        }
      
      }
     
     }
	 status= true;
	 
 }
	 public static void getKey(JSONObject jsonObject, String key)
 
   {
	   System.out.println("tsret");
	   JSONObject innerJSOn = null;
	   boolean exists = jsonObject.has(key);
       Iterator < ? > keys1;
       String nextKeys;
     if (!exists) 
     {
        keys1 = jsonObject.keys();
        while (keys1.hasNext()) 
         {
           nextKeys = (String) keys1.next();
  
     if (jsonObject.get(nextKeys) instanceof JSONObject) 
     {
     if (exists == false) 
     {
                 getKey(jsonObject.getJSONObject(nextKeys), key);
               
     }
     } 
     else if (jsonObject.get(nextKeys) instanceof JSONArray) 
     {
               JSONArray jsonarray = jsonObject.getJSONArray(nextKeys);
               for (int i = 0; i < jsonarray.length(); i++) 
               {
                 String jsonarrayString = jsonarray.get(i).toString();
                  innerJSOn = new JSONObject(jsonarrayString);
                }
     }
     if (exists == false) 
     {
           getKey(innerJSOn, key);
     }
       
     }
     } 
     else 
     {
         parseObject(jsonObject, key);
      }
    }
   
	 public static void writefile() throws IOException
	 {
		
		 if(final_output.size()!=1)
		 {
		 System.out.println("file"+outpur_typevalue);
		 if(outpur_typevalue.contains("Excel"))
		 {
		 String home = System.getProperty("user.home");
		 File file = new File(home+"/Downloads/" +"Jsoncomparison_result.xlsx"); 
		 System.out.println("file name"+file.toString());
		 filelocation =file.toString();
		 FileOutputStream out = new FileOutputStream(file);
         XSSFWorkbook workbook = new XSSFWorkbook();
         XSSFSheet sheet = workbook.createSheet("Execution_Result");

         Iterator <String>i = final_output.iterator();
         int rownum=0;
         int cellnum = 0;
         while (i.hasNext()) 
         {
           
             Row row = sheet.createRow(rownum++);
             cellnum = 0;
           
                 String temp = (String) i.next();
                     Cell cell = row.createCell(cellnum++);
                             cell.setCellValue(temp);

                 

             }
         workbook.write(out);
         out.close();
		 }
		 else
		 {
			 writecsv();
		 }
		 }
		 
	 }
	 
	 public static void writecsv() throws IOException 
	  {
		 String home = System.getProperty("user.home");
		 File file1 = new File(home+"/Downloads/" +"Jsoncomparison_result.csv"); 
		 System.out.println("file name"+file1.toString());
		 filelocation =file1.toString();
		  FileWriter writer = new FileWriter(file1);

		  for (int j = 0; j < final_output.size(); j++) 
		  {
		      writer.append(final_output.get(j));
		      writer.append("\n");
		  }
		  writer.close();
	  }

   
   public static void parseObject(JSONObject json, String key) 
   {
	   System.out.println("Key : "+key+" has value : "+json.get(key));
   }
}
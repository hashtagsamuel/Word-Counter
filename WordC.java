import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
class WordC extends JFrame{
String wcount[];
int count;
String Book;
JTextField input;
JTextArea output;
WordC(){
	Book=null;
	setSize(300,300);
	setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	JButton enter=new JButton("submit");
	add(new JLabel("ENTER TEXT:"));
	input=new JTextField(20);
	add(new JScrollPane(input));
	add(enter);
	enter.addActionListener(new ActionListener(){
                @Override
		public void actionPerformed( ActionEvent ae){
			Getter();
		}
	});
   add(new JLabel("RESULT:"));
   output=new JTextArea(5,10);
   add(output);
   JButton result=new JButton("result");
   add(result);
   result.addActionListener(new ActionListener(){
        @Override
	public void actionPerformed(ActionEvent ae){
                int b=Setter();
		String a;
		a="The number of unique words counted is:";
                StringBuilder s=new StringBuilder();
                s.append(a).append(b).append("\n");
				for(int i=0;i<wcount.length;i++){
					if(wcount[i]!=null){
					s.append(wcount[i]).append("\n");}
				}
		output.setText(String.valueOf(s));
	}
   });
setVisible(true);
}
void Getter(){
Book=input.getText();
}
int Setter(){
	String[] words=Book.split(" ");
	int a=Calculate(words);
return a;
}
int Calculate(String words[]){
boolean[] flag=new boolean[words.length];
wcount=new String[words.length];
int j,i=0,count=0;
for(i=0;i<words.length;i++){
	if(!flag[i]){
		count++;
		for(j=i+1;j<words.length;j++){
			if(words[j].compareTo(words[i])==0){
				flag[j]=true;
				flag[i]=true;
				count--;
			}
		}
	}
}int n=0;
for(int m=0;m<words.length;m++){
	
	if(!flag[m]){
      wcount[n]=words[m];
	  n++;
	}
}
return count;
}
public static void main(String[] args){
WordC words=new WordC();
}}
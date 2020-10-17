import java.util.*;
import java.awt.*;
import java.awt.event.*;  
public class calculator extends Frame implements ActionListener
{	
	static Label lab=new Label("",Label.RIGHT);
	static calculator frm=new calculator();
	static Button add=new Button("+");
	static Button minus=new Button("-");
	static Button mul=new Button("x");
	static Button div=new Button("/");
	static Button zero=new Button("0");
	static Button one=new Button("1");
	static Button two=new Button("2");
	static Button three=new Button("3");
	static Button four=new Button("4");
	static Button five=new Button("5");
	static Button six=new Button("6");
	static Button seven=new Button("7");
	static Button eight=new Button("8");
	static Button nine=new Button("9");
	static Button equal=new Button("=");
	static Button exit=new Button("C");
	static Queue<String> postq = new LinkedList<String>();	
	static Queue<String> postfix = new LinkedList<String>();
	static Vector<Character> v=new Vector<Character>(50);
	static int value=0;
	static int count=0;
	public static void main(String args[])
	{
		frm.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frm.setTitle("Calculator");
		frm.setSize(300,350);
		frm.setLayout(new FlowLayout());
		add.addActionListener(frm);
		minus.addActionListener(frm);
		mul.addActionListener(frm);
		div.addActionListener(frm);
		equal.addActionListener(frm);
		zero.addActionListener(frm);
		one.addActionListener(frm);
		two.addActionListener(frm);
		three.addActionListener(frm);
		four.addActionListener(frm);
		five.addActionListener(frm);
		six.addActionListener(frm);
		seven.addActionListener(frm);
		eight.addActionListener(frm);
		nine.addActionListener(frm);
		exit.addActionListener(frm);
		lab.setBackground(Color.white);
		lab.setForeground(Color.black);
		lab.setFont(new Font("", Font.PLAIN, 23));
		setbuttonsize(); 
		setfontcolor();
		frm.add(lab);
		frm.add(exit);
		frm.add(add);
		frm.add(minus);
		frm.add(mul);
		frm.add(div);
		frm.add(equal);
		frm.add(zero);
		frm.add(one);
		frm.add(two);
		frm.add(three);
		frm.add(four);
		frm.add(five);
		frm.add(six);
		frm.add(seven);
		frm.add(eight);
		frm.add(nine);
		frm.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		Button btn=(Button) e.getSource();
		if(btn==add)
		{
			v.add('+');
			lab.setText(lab.getText() + "+");
		}
		else if(btn==minus)
		{	
			v.add('-');
			lab.setText(lab.getText() + "-");
		}
		else if(btn==mul)
		{
			v.add('x');	
			lab.setText(lab.getText() + "x");
		}
		else if(btn==div)
		{
			v.add('/');
			lab.setText(lab.getText() + "/");
		}
		else if(btn==equal)
		{	
			postq=topostq();
			topostfix();	// set postfix
			String y="";
			evaluation();	// postfix to value
			String stringvalue=Integer.toString(value);
			lab.setText("");
			lab.setText(stringvalue);
			v.clear();
			for(int i=0;i<stringvalue.length();i++)
			{
				v.add(stringvalue.charAt(i));
			}
			count=0;
		}
		else if(btn==zero)
		{
			v.add('0');	
			lab.setText(lab.getText() + "0");
		}
		else if(btn==one)
		{
			v.add('1');
			lab.setText(lab.getText() + "1");
		}
		else if(btn==two)
		{
			v.add('2');
			lab.setText(lab.getText() + "2");
		}
		else if(btn==three)
		{
			v.add('3');				
			lab.setText(lab.getText() + "3");
		}
		else if(btn==four)
		{
			v.add('4');
			lab.setText(lab.getText() + "4");
		}
		else if(btn==five)
		{
			v.add('5');
			lab.setText(lab.getText() + "5");
		}
		else if(btn==six)
		{
			v.add('6');
			lab.setText(lab.getText() + "6");
		}
		else if(btn==seven)
		{
			v.add('7');
			lab.setText(lab.getText() + "7");
		}
		else if(btn==eight)
		{
			v.add('8');
			lab.setText(lab.getText() + "8");
		}
		else if(btn==nine)
		{
			v.add('9');
			lab.setText(lab.getText() + "9");
		}
		else 		
		{	
			value=0;
			v.clear();
			count=0;
			lab.setText("");
		}
		
	}
	static void setfontcolor()
	{	
		add.setForeground(Color.black);
		minus.setForeground(Color.black);
		mul.setForeground(Color.black);
		div.setForeground(Color.black);
		equal.setForeground(Color.black);
		zero.setForeground(Color.black);
		one.setForeground(Color.black);
		two.setForeground(Color.black);
		three.setForeground(Color.black);
		four.setForeground(Color.black);
		five.setForeground(Color.black);
		six.setForeground(Color.black);
		seven.setForeground(Color.black);
		eight.setForeground(Color.black);
		nine.setForeground(Color.black);
		exit.setForeground(Color.black);		
	}
	static void setbuttonsize()
	{	
		lab.setPreferredSize(new Dimension(300,50));
		add.setPreferredSize(new Dimension(70,50));
		minus.setPreferredSize(new Dimension(70,50));
		mul.setPreferredSize(new Dimension(70,50));
		div.setPreferredSize(new Dimension(70,50));
		equal.setPreferredSize(new Dimension(70,50));
		zero.setPreferredSize(new Dimension(70,50));
		one.setPreferredSize(new Dimension(70,50));
		two.setPreferredSize(new Dimension(70,50));
		three.setPreferredSize(new Dimension(70,50));
		four.setPreferredSize(new Dimension(70,50));
		five.setPreferredSize(new Dimension(70,50));
		six.setPreferredSize(new Dimension(70,50));
		seven.setPreferredSize(new Dimension(70,50));
		eight.setPreferredSize(new Dimension(70,50));
		nine.setPreferredSize(new Dimension(70,50));
		exit.setPreferredSize(new Dimension(70,50));
	}
	static Queue<String> topostq()
	{	
		Queue<String> p=new LinkedList<String>();
		boolean c=false;
		String s="";
		for(int i=0;i<v.size();i++)
		{
			if(isnumber(v.get(i))==true)
			{
				String t=Character.toString(v.get(i));
				s=s+t;
			}
			else
			{	
				
				String t=Character.toString(v.get(i));
				p.offer(s);
				count++;
				s="";
				p.offer(t);
				count++;
			}
		}
		p.offer(s);
		count++;
		return p;
	}
	static boolean isnumber(char x)
	{
		if(x=='+')
			return false;
		else if(x=='-')
			return false;
		else if(x=='x')
			return false;
		else if(x=='/')
			return false;
		else
			return true;
		
	}
	static void topostfix()
	{
		Stack<String> tempstack=new Stack<String>();
		tempstack.push("+");
		
		for(int i=0;i<count;i++)
		{
			if(number(postq.peek())==true)
				{
					postfix.offer(postq.poll());
				}
			else
			{
				String t=postq.poll();
				int pri=priority(t);
				int b=tempstack.size();
				if(b==1)
				{
					tempstack.push(t);
				}
				else
				{
					boolean c=false;
					while(tempstack.size()>1)
					{
						String k=tempstack.peek();
						int stackpri=priority(k);
	
						if(stackpri<pri)	
						{
							tempstack.push(t);
							c=true;
							break;
						}
						else
						{
							postfix.offer(k);
							tempstack.pop();
						}
					}
					if(c==false)
						tempstack.push(t);
				}
			}
		}
		while(tempstack.size()>1)
		{	
			//System.out.print(tempstack.peek());
			String k=tempstack.peek();
			postfix.offer(k);
			tempstack.pop();
		}
	}
	static boolean number(String y)
	{	
		if(y.equals("+")==true)
			return false;
		else if(y.equals("-")==true)
			return false;
		else if(y.equals("x")==true)
			return false;
		else if(y.equals("/")==true)
			return false;
		else
			return true;
		
	}
	static int priority(String y)
	{
		if(y.equals("+")==true)
			return 1;
		else if(y.equals("-")==true)
			return 1;
		else if(y.equals("x")==true)
			return 2;
		else
			return 2;
	}
	static void evaluation()
	{
		//boolean c=false;	//first number;
		Stack<String> n=new Stack<String>();
		for(int i=0;i<count;i++)
		{
			String t=postfix.poll();
			if(number(t)==true)
			{
				n.push(t);
			}	
			else
			{
				int temp=n.size();	
				n=operator(t,n);
			}
		}
		value=Integer.parseInt(n.peek());
	}
	static Stack<String> operator(String t,Stack<String> x)
	{
		if(t.equals("+")==true)
		{
			String t1,t2;
			t1=x.peek();
			x.pop();
			int a=Integer.parseInt(t1);
			t2=x.peek();
			int b=Integer.parseInt(t2);
			x.pop();
			b=b+a;
			String y="";
			y=Integer.toString(b);
			x.push(y);
			return x;
		}
		else if(t.equals("-")==true)
		{
			String t1,t2;
			t1=x.peek();
			x.pop();
			int a=Integer.parseInt(t1);
			t2=x.peek();
			int b=Integer.parseInt(t2);
			x.pop();
			b=b-a;
			String y="";
			y=Integer.toString(b);
			x.push(y);
			return x;
		}
		else if(t.equals("x")==true)
		{
			String t1,t2;
			t1=x.peek();
			x.pop();
			int a=Integer.parseInt(t1);
			t2=x.peek();
			int b=Integer.parseInt(t2);
			x.pop();
			b=b*a;
			String y="";
			y=Integer.toString(b);
			x.push(y);
			return x;
		}
		else 
		{
			String t1,t2;
			t1=x.peek();
			x.pop();
			int a=Integer.parseInt(t1);
			t2=x.peek();
			int b=Integer.parseInt(t2);
			x.pop();
			b=b/a;
			String y="";
			y=Integer.toString(b);
			x.push(y);
			return x;
		}
	}
}

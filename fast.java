package fast2;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.*;
import static java.lang.System.out;

 class Fast2 {
  //  int entropy;
     ArrayList<Double> entropy = new ArrayList<Double>();
     ArrayList<Double> gain = new ArrayList<Double>();
     ArrayList<Double> su = new ArrayList<Double>();
     ArrayList<Double> sutarget = new ArrayList<Double>();
     ArrayList<Integer> source=new ArrayList<Integer>();
     ArrayList<Integer> destination=new ArrayList<Integer>();
     ArrayList<Double> minwt = new ArrayList<Double>();
     
     

    public Fast2() {
        try {
            ArrayList<String> risk = new ArrayList<String>();
            ArrayList<Double> risk1=new ArrayList<Double>();
            ArrayList<String> risk2 = new ArrayList<String>();
            ArrayList<Double> rch=new ArrayList<Double>();
            ArrayList<Double> rdebit=new ArrayList<Double>();
            ArrayList<Double> rct=new ArrayList<Double>();
            ArrayList<Double> rincome=new ArrayList<Double>();
            ArrayList<Double> chdebit=new ArrayList<Double>();
            ArrayList<Double> chct=new ArrayList<Double>();
            ArrayList<Double> chincome=new ArrayList<Double>();
            ArrayList<Double> debitct=new ArrayList<Double>();
            ArrayList<Double> debitincome=new ArrayList<Double>();
            ArrayList<Double> ctincome=new ArrayList<Double>();
            ArrayList<String> ch = new ArrayList<String>();
            ArrayList<Double> ch1=new ArrayList<Double>();
            ArrayList<String> ch2 = new ArrayList<String>();
            ArrayList<String> debit = new ArrayList<String>();
            ArrayList<Double> debit1=new ArrayList<Double>();
            ArrayList<String> ct = new ArrayList<String>();
            ArrayList<Double> ct1=new ArrayList<Double>();
            ArrayList<String> income = new ArrayList<String>();
            ArrayList<Double> income1=new ArrayList<Double>();
            ArrayList dataset = new ArrayList();
            ArrayList datasetTokens = new ArrayList();

            ArrayList<Double> entropyxy = new ArrayList<Double>();
            BufferedReader br = new BufferedReader(new FileReader("D:\\M.Tech_Project\\dataset.txt"));
            String temp = "";

            while ((temp = br.readLine()) != null) 
			{
                dataset.add(temp);
                StringTokenizer st = new StringTokenizer(temp, " ");
                while (st.hasMoreTokens()) 
				{
                    datasetTokens.add(st.nextToken());
                }
                StringTokenizer str = new StringTokenizer(temp, " ");
                while (str.hasMoreTokens()) 
				{
                    risk.add(str.nextToken());
                    ch.add(str.nextToken());
                    debit.add(str.nextToken());
                    ct.add(str.nextToken());
                    income.add(str.nextToken());

                }       

            }
            
            System.out.println("Risk From Function is " +checkr);
           
            System.out.println("Risk:" + risk);
            System.out.println("Credit History:" + ch);
            System.out.println("Debit" + debit);
            System.out.println("Collateral" + ct);
            System.out.println("Income" + income);
            
            double size = risk.size();
            Set<String> unique2 = new HashSet<String>(ch);
            System.out.println("Credit History");
            double entropy2=0.0;
            for (String key2 : unique2) {
                double frequency=(double)Collections.frequency(ch, key2)/ch.size();
                ch2.add(key2);
                entropy2 -= frequency * (Math.log(frequency) / Math.log(2));
                double count=Collections.frequency(ch, key2);

                System.out.println(key2 + ": " + count);
                ch1.add(count);
                
            }

            
          
          Set<String> unique1 = new HashSet<String>(risk);
            System.out.println("Risk");
            double entropy1=0.0;
            double result5=0.0;
            double sum=0.0;
            for (String key1 : unique1) {
                double frequency=(double)Collections.frequency(risk, key1)/risk.size();
                risk2.add(key1);
                entropy1 -= frequency * (Math.log(frequency) / Math.log(2));
                double count=Collections.frequency(risk, key1);
                System.out.println(key1 + ": " + count);
                
                risk1.add(count);
              
            }
             
 
 //Calculation of Entropy of Risk,Credit History
 Symm sm = new Symm();
 double riskch = sm.risk_ch(risk, ch, risk1, ch1);
 System.out.println("Entropy of Risk,Credit History from Functions is "+riskch);
 
 //Calculation of Entropy of Risk,Risk
 double riskr=sm.risk_risk(risk, risk1);
 System.out.println("Entropy of Risk,Risk from Functions is "+riskr);
 
 //Calculation of SU of R,R
 double gainrr = entropy1-riskr;
 double surr=(2*gainrr/(entropy1+entropy1));
 
 System.out.println("SU OF R,R is "+surr);
 
 
 
 
           
 
  

            Set<String> unique3 = new HashSet<String>(debit);
            System.out.println("Debit");
            double entropy3=0.0;
            for (String key3 : unique3) {
                double frequency=(double)Collections.frequency(debit, key3)/debit.size();
                entropy3 -= frequency * (Math.log(frequency) / Math.log(2));
                double count=Collections.frequency(debit, key3);

                System.out.println(key3 + ": " + count);
                debit1.add(count);
            }
            
            

//Calculation of Entropy of Risk,Debit
            
         
            
            //ArrayList checkr = new ArrayList<String>(); 
                    double rdb=sm.risk_debit(risk,debit,risk1,debit1);
                    System.out.println("Entropy of Risk,Debit from Functions is "+rdb);
            
           
     //Calculation of Risk,Collateral
                    
            Set<String> unique4 = new HashSet<String>(ct);
            System.out.println("Collateral");
            double entropy4=0.0;
            for (String key4 : unique4) {
                double frequency=(double)Collections.frequency(ct, key4)/ct.size();
                entropy4 -= frequency * (Math.log(frequency) / Math.log(2));
                double count=Collections.frequency(ct, key4);
                System.out.println(key4 + ": " + count);
                ct1.add(count);
            }
            
            double riskct=sm.risk_Ct(risk,ct,risk1,ct1);
                    System.out.println("Entropy of Risk,Collateral from Functions is"+riskct);
            
 //Calculation of Entropy of Risk,Income
 
            Set<String> unique5 = new HashSet<String>(income);
            System.out.println("Income");
            double entropy5=0.0;
            for (String key5 : unique5) {
                double frequency=(double)Collections.frequency(income, key5)/income.size();
                entropy5 -= frequency * (Math.log(frequency) / Math.log(2));
                double count=Collections.frequency(income, key5);
                System.out.println(key5 + ": " + count);
                income1.add(count);
            }
  
            double riskinc =sm.risk_income(risk,income,risk1,income1);
            System.out.println("Entropy of Risk,Income from Functions is"+riskinc);
            
           
 System.out.println("Income1 Array "+income1);
 System.out.println("RINCOME Array "+rincome);
 

            System.out.println("Size " + size);
            System.out.println("Risk1 Array"+risk1);
            for(int i=0;i<3;i++)
            System.out.println(" Risk2 "+risk1.get(i));
            System.out.println("Credit History1 Array "+ch1);
            System.out.println("Debit1 Array "+debit1);
            System.out.println("Collatera1 Array "+ct1);
            System.out.println("Income1 Array "+income1);
           
        /*    double entropy=0;
            for(int i=0;i<3;i++)
            {
            
                 double ent1=risk1.get(i)/size;
                 entropy=entropy+((ent1)*(Math.log(ent1)/Math.log(2)));
            }
            
            System.out.println("Ent "+entropy);*/
           // System.out.println("Entropy "+result);
            
            entropy.add(entropy1);
            entropy.add(entropy2);
            entropy.add(entropy3);
            entropy.add(entropy4);
            entropy.add(entropy5);
            System.out.println("Entropy Array is "+entropy);
            
           
             System.out.println("Distinct strings in Risk Array is "+unique1);
             System.out.println("Distinct strings in CH Array is "+unique2);
             System.out.println("Distinct strings in Debit Array is "+unique3);
             System.out.println("Distinct strings CT Array is "+unique4);
             System.out.println("Distinct strings in Income Array is "+unique5);
             
             //Symmetric Uncertainty of Risk,Credit History
             
         
   
     System.out.println("Risk2 Array "+risk2);
     System.out.println("Credit History2 Array "+ch2);
     
    
     
     
     //Calculation of Entropy of Credit History,Debit
     double chdb=sm.ch_db(ch,debit,ch1,debit1);
     System.out.println("Entropy of Credit History,Debit from function is"+chdb);
     
     
     //Calculation of Credit History,Collateral
    
     double crhct=sm.ch_ct(ch, ct, ch1, ct1);
     System.out.println("Entropy of Credit History, Collateral from Functions is "+crhct);
     
     
 //Calculation of Entropy of Credit History,Income
     
     double chinc=sm.ch_income(ch, income, ch1, income1);
     System.out.println("Entropy of Credit History,Income from Functions is "+chinc);
     
 //Calculation of Entropy of Debit,CT
   
     double dbct = sm.debit_ct(debit, ct, debit1, ct1);
     System.out.println("Entropy of Debit,CT from Functions is "+dbct);
     
     //Calculation of Entropy of Debit,Income
     
      double dbinc = sm.debit_income(debit, income, debit1, income1);
     System.out.println("Entropy of Debit,Income from Functions is "+dbinc);
     
     //Calculation of Entropy of CT,Income
     
      double ctinc = sm.ct_income(ct, income, ct1, income1);
     System.out.println("Entropy of CT,Income from Functions is "+ctinc);
     
    
 
 //Adding Entropy xy values to entropyxy
 
 entropyxy.add(riskch);
 entropyxy.add(rdb);
 entropyxy.add(riskct);
 entropyxy.add(riskinc);
 entropyxy.add(chdb);
 entropyxy.add(crhct);
 entropyxy.add(chinc);
 entropyxy.add(dbct);
 entropyxy.add(dbinc);
 entropyxy.add(ctinc);
 
 System.out.println("Entropy of x,y values : "+entropyxy);
 
 int p=0;
 int size1;
 double c1;
 
 size1=entropy.size()-1;
 for(int i=0;i<entropy.size();i++)
 {
     for(int m=0;m<size1;m++,p++)
     {
         c1=entropy.get(i)-entropyxy.get(p);
         gain.add(c1);
         
     }
     size1--;
 }
     
 System.out.println("Gain Values :"+gain);
 
 //Calculation Symmetric Uncertainty of Features
 
 int a=0,b=1;
 int size2;
 size2=entropy.size()-1;
 for(int i=0;i<entropy.size();i++)
 {
     for(int m=0,n=b;m<size2;m++,a++)
     {
         
         double c2;
         if(i==0)
         {
         c2=(2*gain.get(a))/(entropy.get(i)+entropy.get(n));
         sutarget.add(c2);
         n++;
         }
         else
         {
         c2=(2*gain.get(a))/(entropy.get(i)+entropy.get(n));
         su.add(c2);
         n++; 
         }
     }
     b++;
     size2--;
    
 }
 System.out.println("Symmetric Uncertainty Values: "+sutarget);
 System.out.println("Symmetric Uncertainty Values: "+su);
 
 
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public ArrayList<Double> Entropy()
    {
        return entropy;
        
    }
     public ArrayList<Double> Su()
    {
        return su;
        
    }
}
 
 class Prims extends Fast2
{
    private boolean unsettled[];
    private boolean settled[];
    private int numberofvertices;
    private double adjacencyMatrix[][];
    private double key[];
    public static final int INFINITE = 999;
    private int parent[];
 
    public Prims(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        unsettled = new boolean[numberofvertices + 1];
        settled = new boolean[numberofvertices + 1];
        adjacencyMatrix = new double[numberofvertices + 1][numberofvertices + 1];
        key = new double[numberofvertices + 1];
        parent = new int[numberofvertices + 1];
    }
 
    public int getUnsettledCount(boolean unsettled[])
    {
        int count = 0;
        for (int index = 0; index < unsettled.length; index++)
        {
            if (unsettled[index])
            {
                count++;
            }
        }
        return count;
    }
 
    public void primsAlgorithm(double adjacencyMatrix[][])
    {
        int evaluationVertex;
        for (int source = 1; source <= numberofvertices; source++)
        {
            for (int destination = 1; destination <= numberofvertices; destination++)
            {
                    this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
            }
        }
        
        
 
        for (int index = 1; index <= numberofvertices; index++)
        {
            key[index] = INFINITE;
        }
        key[1] = 0;
        unsettled[1] = true;
        parent[1] = 1;
 
        while (getUnsettledCount(unsettled) != 0)
        {
            evaluationVertex = getMimumKeyVertexFromUnsettled(unsettled);
            unsettled[evaluationVertex] = false;
            settled[evaluationVertex] = true;
            evaluateNeighbours(evaluationVertex);
        }
    } 
 
    private int getMimumKeyVertexFromUnsettled(boolean[] unsettled2)
    {
        double min = Integer.MAX_VALUE;
        int node = 0;
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
            if (unsettled[vertex] == true && key[vertex] < min)
            {
                node = vertex;
                min = key[vertex];
            }
        }
        return node;
    }
 
    public void evaluateNeighbours(int evaluationVertex)
    {
 
        for (int destinationvertex = 1; destinationvertex <= numberofvertices; destinationvertex++)
        {
            if (settled[destinationvertex] == false)
            {
                if (adjacencyMatrix[evaluationVertex][destinationvertex] != INFINITE)
                {
                    if (adjacencyMatrix[evaluationVertex][destinationvertex] < key[destinationvertex])
                    {
                        key[destinationvertex] = adjacencyMatrix[evaluationVertex][destinationvertex];
                        parent[destinationvertex] = evaluationVertex;
                    }
                    unsettled[destinationvertex] = true;
                }
            }
        }
    }
 
    public void printMST()
    {
        System.out.println("SOURCE  : DESTINATION = WEIGHT");
        for (int vertex = 2; vertex <= numberofvertices; vertex++)
        {
            System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
            source.add(parent[vertex]);
            destination.add(vertex);
            minwt.add(adjacencyMatrix[parent[vertex]][vertex]);
        }
        System.out.println("Source array :"+source);
        System.out.println("Destination array :"+destination);
        System.out.println("Min Weight array :"+minwt);
    }
 
    public static void main(String[] args)
    {
        Fast2 sa=new Fast2();
        //sa.numbers();
        ArrayList<Double> entropy=sa.Entropy();
        System.out.println("Entropy Values Passed "+entropy);
         ArrayList<Double> su=sa.Su();
        System.out.println("SU Values Passed "+su);
        double su1[]=new double[su.size()+1];
        for(int i=0;i<su.size();i++)
        {
            su1[i+1]=su.get(i);
            //System.out.println("SU Values Passed "+su1[i+1]);
        }
        
        
        double adjacency_matrix[][];
        int number_of_vertices;
        Scanner scan = new Scanner(System.in);
        //int a[]=new int[11];
        double g[][]=new double[5][5];
        int k=1,l=0;
     /*   for(int i=1;i<=10;i++)
        {
            a[i]=i;
        }*/
        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=4;j++)
            {
                if(i==j)
                g[i][j]=0;
                else if(i<j)
                {
                    g[i][j]=su1[k];
                    k++;
                }
                else
                    g[i][j]=g[j][i];
            }        
         }
        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=4;j++)
                System.out.print(g[i][j]+"                ");
            System.out.println();
        }
 
        try
        {
            System.out.println("Enter the number of vertices");
            number_of_vertices = scan.nextInt();
            adjacency_matrix = new double[number_of_vertices + 1][number_of_vertices + 1];
 
            System.out.println("Weighted Matrix for the graph is : ");
            for (int i = 1; i <= number_of_vertices; i++)
            {
                for (int j = 1; j <= number_of_vertices; j++)
                {
                    adjacency_matrix[i][j] = g[i][j];
                    System.out.print(adjacency_matrix[i][j]+" ");
                    if (i == j)
                    {
                        adjacency_matrix[i][j] = 0.0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0.0)
                    {
                        adjacency_matrix[i][j] = INFINITE;
                    }
                    
                }
                System.out.println();
            }
 
            Prims prims = new Prims(number_of_vertices);
            prims.primsAlgorithm(adjacency_matrix);
            prims.printMST();
            int temp1,temp2;
           for(int i=0;i<3;i++)
            {
                if((prims.minwt.get(i)<prims.sutarget.get(prims.source.get(i)-1)))
                        {
                            if((prims.minwt.get(i))<prims.sutarget.get(prims.destination.get(i)-1))
                            {
                            //temp1=prims.source.get(i);
                            //System.out.println("TEmp "+temp1);
                         //  prims.source.remove(i);
                            //temp2=prims.dest.get(i);
                            //System.out.println("TEmp2 "+temp2);
                        // prims.dest.remove(i);
                                prims.source.remove(i);
                                prims.destination.remove(i);
                           prims.source.add(i, 0);
                            prims.destination.add(i,0);
                            }
                            
                        }
            }
          
            System.out.println("Source After Clustering "+prims.source);
              System.out.println("Source Size After Clustering "+prims.source.size());
            System.out.println("Destination After Clustering "+prims.destination);
            int count=1;
            for(int i=0;i<3;i++)
            {
                if(prims.source.get(i)==0)
                    count++;
            }
            
            System.out.println("No of clusters "+count);
           
 
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}
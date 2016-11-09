/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fast2;

import java.util.ArrayList;

/**
 *
 * @author BALAJI
 */
public class Symm{
    
    int k1,k;
    ArrayList<Double> rr = new ArrayList<Double>();
    ArrayList<Double> rch = new ArrayList<Double>();
    ArrayList<Double> rdebit = new ArrayList<Double>();
    ArrayList<Double> rct=new ArrayList<Double>();
    ArrayList<Double> rincome=new ArrayList<Double>();
    ArrayList<Double> chdebit=new ArrayList<Double>();
    ArrayList<Double> chct = new ArrayList<Double>();
    ArrayList<Double> chincome=new ArrayList<Double>();
    ArrayList<Double> debitct = new ArrayList<Double>();
    ArrayList<Double> debitincome = new ArrayList<Double>();
    ArrayList<Double> ctincome = new ArrayList<Double>();
    
    
     public double risk_risk(ArrayList<String> risk,ArrayList<Double> risk1)
    {
        double size=risk.size();
        
         double hh=0,hl=0,hm=0,lh=0,ll=0,lm=0,mh=0,ml=0,mm=0;
          for(int i=0;i<risk.size();i++)
          {
              if(risk.get(i).equals("high"))
              {
                  if (risk.get(i).equals("high"))
                      hh++;
                  else if(risk.get(i).equals("low"))
                      hl++;
                  else
                      hm++;
                  
              }
              if(risk.get(i).equals("low"))
              {
                  if (risk.get(i).equals("high"))
                      lh++;
                  else if(risk.get(i).equals("low"))
                      ll++;
                  else
                      lm++;
                  
              }
              if(risk.get(i).equals("moderate"))
              {
                  if (risk.get(i).equals("high"))
                      mh++;
                  else if(risk.get(i).equals("low"))
                      ml++;
                  else
                      mm++;
                  
              }
              
          }
          
          rr.add(hh);
          rr.add(hm);
          rr.add(hl);
          rr.add(lh);
          rr.add(lm);
          rr.add(ll);
          rr.add(mh);
          rr.add(mm);
          rr.add(ml);
          
                       int j=0;
             double riskr=0,temp11=0,temp12=0;
           int k=0;
            for(int i=0;i<risk1.size();i++)
            {
                
                temp11=risk1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k=0,temp12=0;k<risk1.size();k++,j++) 
                {
                    if(rr.get(j)==0.0)
                        temp12+=0.0;
                    else
                    {
                        temp12+=((rr.get(j)/risk1.get(i))*(Math.log10(rr.get(j)/risk1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                riskr+=temp11*temp12;
                
                //System.out.println("SUM :"+summ);
            }
           riskr=-riskr/Math.log10(2);
 System.out.println("Result is "+riskr);
           
 //System.out.println("CH1 Array "+ch1);
 System.out.println("RR Array "+rr);
 //System.out.println("Entropy of risk,ch "+result5);
 System.out.println("Entropy of risk,risk "+riskr);
        
        return(riskr);
    }
    
    public double risk_ch(ArrayList<String> risk,ArrayList<String> ch,ArrayList<Double> risk1,ArrayList<Double> ch1)
    {
        
        double size=risk.size();
        double bh=0,bl=0,bm=0,uh=0,ul=0,um=0,gh=0,gl=0,gm=0;
          for(int i=0;i<ch.size();i++)
          {
              if(ch.get(i).equals("bad"))
              {
                  if (risk.get(i).equals("high"))
                      bh++;
                  else if(risk.get(i).equals("low"))
                      bl++;
                  else
                      bm++;
                  
              }
              if(ch.get(i).equals("unknown"))
              {
                  if (risk.get(i).equals("high"))
                      uh++;
                  else if(risk.get(i).equals("low"))
                      ul++;
                  else
                      um++;
                  
              }
              if(ch.get(i).equals("good"))
              {
                  if (risk.get(i).equals("high"))
                      gh++;
                  else if(risk.get(i).equals("low"))
                      gl++;
                  else
                      gm++;
                  
              }
              
          }
          
          rch.add(uh);
          rch.add(um);
          rch.add(ul);
          rch.add(gh);
          rch.add(gm);
          rch.add(gl);
          rch.add(bh);
          rch.add(bm);
          rch.add(bl);
          
                       int j=0;
             double sum1=0,temp11=0,temp12=0;
//           int k=0;
            for(int i=0;i<ch1.size();i++)
            {
                
                temp11=ch1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k=0,temp12=0;k<risk1.size();k++,j++) 
                {
                    if(rch.get(j)==0.0)
                        temp12+=0.0;
                    else
                    {
                        temp12+=((rch.get(j)/ch1.get(i))*(Math.log10(rch.get(j)/ch1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum1+=temp11*temp12;
                
                //System.out.println("SUM :"+summ);
            }
           sum1=-sum1/Math.log10(2);
 System.out.println("Result is "+sum1);
           
 System.out.println("CH1 Array "+ch1);
 System.out.println("RCH Array "+rch);
 //System.out.println("Entropy of risk,ch "+result5);
 System.out.println("Entropy of risk,ch "+sum1);
 
 return(sum1);

    }
    public double risk_debit(ArrayList<String> risk,ArrayList<String> debit,ArrayList<Double> risk1,ArrayList<Double> debit1)
    {
        System.out.println("Risk Array in Entropy Class is "+risk);
       // System.out.println("Debit Array in Entropy Class is "+debit);
        
        double size = risk.size();
        
        double hh=0,hl=0,hm=0,lh=0,ll=0,lm=0;
     
          for(int i=0;i<debit.size();i++)
          {
              if(debit.get(i).equals("high"))
              {
                  if (risk.get(i).equals("high"))
                      hh++;
                  else if(risk.get(i).equals("low"))
                      hl++;
                  else
                      hm++;
                  
              }
              if(debit.get(i).equals("low"))
              {
                  if (risk.get(i).equals("high"))
                      lh++;
                  else if(risk.get(i).equals("low"))
                      ll++;
                  else
                      lm++;
                  
              }
             
              
          }
          
     System.out.println("HH,HL,HM "+hh+" "+hl+" "+hm);
     System.out.println("LH,LL,LM "+lh+" "+ll+" "+lm);
     
     rdebit.add(hh);
     rdebit.add(hm);
     rdebit.add(hl);
     rdebit.add(lh);
     rdebit.add(lm);
     rdebit.add(ll);
     
            int j1=0;
             double sum2=0,temp13=0,temp14;
             int k1=0;
            for(int i=0;i<debit1.size();i++)
            {
                
                temp13=debit1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp14=0;k1<risk1.size();k1++,j1++) 
                {
                    if(rdebit.get(j1)==0.0)
                        temp14+=0.0;
                    else
                    {
                        temp14+=((rdebit.get(j1)/debit1.get(i))*(Math.log10(rdebit.get(j1)/debit1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum2+=temp13*temp14;
                
                //System.out.println("SUM :"+summ);
            }
           sum2=-sum2/Math.log10(2);
 
           
 System.out.println("Debit1 Array "+debit1);
 System.out.println("RDebit Array "+rdebit);
 
 System.out.println("Entropy of Risk,Debit "+sum2);
    
 return(sum2);
    }
    
    public double risk_Ct(ArrayList<String> risk,ArrayList<String> ct,ArrayList<Double> risk1,ArrayList<Double> ct1)
    {
       // ArrayList<Double> rct = new ArrayList<Double>();
        double size = risk.size();
        double nh=0,nl=0,nm=0,ah=0,al=0,am=0;
     
          for(int i=0;i<ct.size();i++)
          {
              if(ct.get(i).equals("none"))
              {
                  if (risk.get(i).equals("high"))
                      nh++;
                  else if(risk.get(i).equals("low"))
                      nl++;
                  else
                      nm++;
                  
              }
              if(ct.get(i).equals("adequate"))
              {
                  if (risk.get(i).equals("high"))
                      ah++;
                  else if(risk.get(i).equals("low"))
                      al++;
                  else
                      am++;
                  
              }
             
              
          }
          System.out.println("NH,NL,NM "+nh+" "+nl+" "+nm);
     System.out.println("AH,AL,AM "+ah+" "+al+" "+am);
     
    
     rct.add(ah);
     rct.add(am);
     rct.add(al);
     rct.add(nh);
     rct.add(nm);
     rct.add(nl);
     
     int j2=0;
             double sum3=0,temp15,temp16;
             int k2=0,k1;
            for(int i=0;i<ct1.size();i++)
            {
                
                temp15=ct1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp16=0;k1<risk1.size();k1++,j2++) 
                {
                    if(rct.get(j2)==0.0)
                        temp16+=0.0;
                    else
                    {
                        temp16+=((rct.get(j2)/ct1.get(i))*(Math.log10(rct.get(j2)/ct1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum3+=temp15*temp16;
                
                //System.out.println("SUM :"+summ);
            }
           sum3=-sum3/Math.log10(2);
 
           
 System.out.println("CT1 Array "+ct1);
 System.out.println("RCT Array "+rct);
 
 System.out.println("Entropy of Risk,Collateral "+sum3);

    return(sum3);
    }
    
    
    public double risk_income(ArrayList<String> risk,ArrayList<String> income,ArrayList<Double> risk1,ArrayList<Double> income1)
    {
        double size=risk.size();
        
    double ihh=0,ihl=0,ihm=0,imh=0,iml=0,imm=0,ilh=0,ill=0,ilm=0;
          for(int i=0;i<income.size();i++)
          {
              if(income.get(i).equals("high"))
              {
                  if (risk.get(i).equals("high"))
                      ihh++;
                  else if(risk.get(i).equals("low"))
                      ihl++;
                  else
                      ihm++;
                  
              }
              if(income.get(i).equals("moderate"))
              {
                  if (risk.get(i).equals("high"))
                      imh++;
                  else if(risk.get(i).equals("low"))
                      iml++;
                  else
                      imm++;
                  
              }
              if(income.get(i).equals("low"))
              {
                  if (risk.get(i).equals("high"))
                      ilh++;
                  else if(risk.get(i).equals("low"))
                      ill++;
                  else
                      imm++;
                  
              }
              
          }
     System.out.println("IHH,IHL,IHM "+ihh+" "+ihl+" "+ihm);
     System.out.println("IMH,IML,IMM "+imh+" "+iml+" "+imm);
     System.out.println("ILH,ILLL,ILM "+ilh+" "+ill+" "+ilm);
     
      rincome.add(imh);
      rincome.add(imm);
      rincome.add(iml);
      rincome.add(ihh);
      rincome.add(ihm);
      rincome.add(ihl);
      rincome.add(ilh);
      rincome.add(ilm);
      rincome.add(ill);
     
      
      int j3=0;
             double sum4=0,temp16,temp17;
             int k1=0;
            for(int i=0;i<income1.size();i++)
            {
                
                temp16=income1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp17=0;k1<risk1.size();k1++,j3++) 
                {
                    if(rincome.get(j3)==0.0)
                        temp17+=0.0;
                    else
                    {
                        temp17+=((rincome.get(j3)/income1.get(i))*(Math.log10(rincome.get(j3)/income1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum4+=temp16*temp17;
                
                //System.out.println("SUM :"+summ);
            }
           sum4=-sum4/Math.log10(2);
 
           
 System.out.println("Income1 Array "+income1);
 System.out.println("RINCOME Array "+rincome);
 
 System.out.println("Entropy of Risk,Income "+sum4);
 
 return(sum4);
    }
    
    public double ch_db(ArrayList<String> ch,ArrayList<String> debit,ArrayList<Double> ch1,ArrayList<Double> debit1)
    {
        
         double hb=0,hu=0,hg=0,lb=0,lu=0,lg=0;
         double size=ch.size();
          for(int i=0;i<debit.size();i++)
          {
              if(debit.get(i).equals("high"))
              {
                  if (ch.get(i).equals("bad"))
                      hb++;
                  else if(ch.get(i).equals("unknown"))
                      hu++;
                  else
                      hg++;
                  
              }
              if(debit.get(i).equals("low"))
              {
                  if (ch.get(i).equals("bad"))
                      lb++;
                  else if(ch.get(i).equals("unknown"))
                      lu++;
                  else
                      lg++;
                  
              }
             
              
          }
          System.out.println("HB,HU,HG "+hb+" "+hu+" "+hg);
     System.out.println("LB,LU,LG "+lb+" "+lu+" "+lg);
     
     chdebit.add(hb);
     chdebit.add(hu);
     chdebit.add(hg);
     chdebit.add(lb);
     chdebit.add(lu);
     chdebit.add(lg);
     
     int j4=0;
             double sum5=0,temp19,temp20;
             //int k3=0;
            for(int i=0;i<debit1.size();i++)
            {
                
                temp19=debit1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp20=0;k1<ch1.size();k1++,j4++) 
                {
                    if(chdebit.get(j4)==0.0)
                        temp20+=0.0;
                    else
                    {
                        temp20+=((chdebit.get(j4)/debit1.get(i))*(Math.log10(chdebit.get(j4)/debit1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum5+=temp19*temp20;
                
                //System.out.println("SUM :"+summ);
            }
           sum5=-sum5/Math.log10(2);
 
           
 System.out.println("Debit1 Array "+debit1);
 System.out.println("CH Debit Array "+chdebit);
 
 System.out.println("Entropy of CH,Debit "+sum5);
        return(sum5);
    }
    public double ch_ct(ArrayList<String> ch,ArrayList<String> ct,ArrayList<Double> ch1,ArrayList<Double> ct1)
    {
        double size=ch.size();
         double nb=0,nu=0,ng=0,ab=0,au=0,ag=0;
     
          for(int i=0;i<ct.size();i++)
          {
              if(ct.get(i).equals("none"))
              {
                  if (ch.get(i).equals("bad"))
                      nb++;
                  else if(ch.get(i).equals("unknown"))
                      nu++;
                  else
                      ng++;
                  
              }
              if(ct.get(i).equals("adequate"))
              {
                  if (ch.get(i).equals("bad"))
                      ab++;
                  else if(ch.get(i).equals("unknown"))
                      au++;
                  else
                      ag++;
                  
              }
             
              
          }
          System.out.println("NB,NU,NG "+nb+" "+nu+" "+ng);
     System.out.println("AB,AU,AG "+ab+" "+au+" "+ag);
     
     chct.add(ab);
     chct.add(au);
     chct.add(ag);
     chct.add(nb);
     chct.add(nu);
     chct.add(ng);
     
      int j5=0;
             double sum6=0,temp21,temp22;
             //int k3=0;
            for(int i=0;i<ct1.size();i++)
            {
                
                temp21=ct1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp22=0;k1<ch1.size();k1++,j5++) 
                {
                    if(chct.get(j5)==0.0)
                        temp22+=0.0;
                    else
                    {
                        temp22+=((chct.get(j5)/ct1.get(i))*(Math.log10(chct.get(j5)/ct1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum6+=temp21*temp22;
                
                //System.out.println("SUM :"+summ);
            }
           sum6=-sum6/Math.log10(2);
 
           
 System.out.println("CT1 Array "+ct1);
 System.out.println("CH CT Array "+chct);
 
 System.out.println("Entropy of CH,CT "+sum6);
    
        
        
        return(sum6);
    }
    
    public double ch_income(ArrayList<String> ch,ArrayList<String> income,ArrayList<Double> ch1,ArrayList<Double> income1)
    {
        
        double size=ch.size();
        
        double ihb=0,ihu=0,ihg=0,imb=0,imu=0,img=0,ilb=0,ilu=0,ilg=0;
     
          for(int i=0;i<income.size();i++)
          {
              if(income.get(i).equals("high"))
              {
                  if (ch.get(i).equals("bad"))
                      ihb++;
                  else if(ch.get(i).equals("unknown"))
                      ihu++;
                  else
                      ihg++;
                  
              }
             else if(income.get(i).equals("moderate"))
              {
                  if (ch.get(i).equals("bad"))
                      imb++;
                  else if(ch.get(i).equals("unknown"))
                      imu++;
                  else
                      img++;
                  
              }
              else
              {
                  if (ch.get(i).equals("bad"))
                      ilb++;
                  else if(ch.get(i).equals("unknown"))
                      ilu++;
                  else
                      ilg++;
                  
                  
              }
             
              
          }
          
     System.out.println("IHB,IHU,IHG "+ihb+" "+ihu+" "+ihg);
     System.out.println("IMB,IMU,IMG "+imb+" "+imu+" "+img);
     System.out.println("ILB,ILU,ILG "+ilb+" "+ilu+" "+ilg);
    
     chincome.add(imb);
     chincome.add(imu);
     chincome.add(img);
     chincome.add(ihb);
     chincome.add(ihu);
     chincome.add(ihg);
     chincome.add(ilb);
     chincome.add(ilu);
     chincome.add(ilg);
     
     int j6=0;
             double sum7=0,temp23,temp24;
             //int k3=0;
            for(int i=0;i<income1.size();i++)
            {
                
                temp23=income1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp24=0;k1<ch1.size();k1++,j6++) 
                {
                    if(chincome.get(j6)==0.0)
                        temp24+=0.0;
                    else
                    {
                        temp24+=((chincome.get(j6)/income1.get(i))*(Math.log10(chincome.get(j6)/income1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum7+=temp23*temp24;
                
                //System.out.println("SUM :"+summ);
            }
           sum7=-sum7/Math.log10(2);
 
           
 System.out.println("Income1 Array "+income1);
 System.out.println("CH Income Array "+chincome);
 
 System.out.println("Entropy of CH,Income "+sum7);
 
        
        return(sum7);
    }
    
    public double debit_ct(ArrayList<String> debit,ArrayList<String> ct,ArrayList<Double> debit1,ArrayList<Double> ct1)
    {
        double size=debit.size();
        double cnh=0,cnl=0,cah=0,cal=0;
     
          for(int i=0;i<ct.size();i++)
          {
              if(ct.get(i).equals("none"))
              {
                  if (debit.get(i).equals("high"))
                      cnh++;
                  
                  else
                      cnl++;
                  
              }
              if(ct.get(i).equals("adequate"))
              {
                  if (debit.get(i).equals("high"))
                      cah++;
                 
                  else
                      cal++;
                  
              }
             
              
          }
          System.out.println("CNH,CNL"+cnh+" "+cnl);
     System.out.println("CAH,CAL "+cah+" "+cal);
     
     
     debitct.add(cah);
     debitct.add(cal);
     debitct.add(cnh);
     debitct.add(cnl);
     
     int j7=0;
             double sum8=0,temp25,temp26;
             //int k3=0;
            for(int i=0;i<ct1.size();i++)
            {
                
                temp25=ct1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp26=0;k1<debit1.size();k1++,j7++) 
                {
                    if(debitct.get(j7)==0.0)
                        temp26+=0.0;
                    else
                    {
                        temp26+=((debitct.get(j7)/ct1.get(i))*(Math.log10(debitct.get(j7)/ct1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum8+=temp25*temp26;
                
                //System.out.println("SUM :"+summ);
            }
           sum8=-sum8/Math.log10(2);
 
           
 System.out.println("CT1 Array "+ct1);
 System.out.println("Debit CT Array "+debitct);
 
 System.out.println("Entropy of Debit,CT "+sum8);
        
        return(sum8);
    }
    
    public double debit_income(ArrayList<String> debit,ArrayList<String> income,ArrayList<Double> debit1,ArrayList<Double> income1)
    {
    
        double size=debit.size();
         double idhh=0,idhl=0,idmh=0,idml=0,idlh=0,idll=0;
     
          for(int i=0;i<income.size();i++)
          {
              if(income.get(i).equals("high"))
              {
                  if (debit.get(i).equals("high"))
                      idhh++;
                  
                  else
                      idhl++;
                  
              }
             else if(income.get(i).equals("moderate"))
              {
                  if (debit.get(i).equals("high"))
                      idmh++;
                 
                  else
                      idml++;
                  
              }
              else
              {
                  if (debit.get(i).equals("high"))
                      idlh++;
                 
                  else
                      idll++;
                  
              }
             
              
          }
          System.out.println("IDHH,IDHL"+idhh+" "+idhl);
     System.out.println("IDMH,IDML "+idmh+" "+idml);
     System.out.println("IDLH,IDLL "+idlh+" "+idll);
     
    
     debitincome.add(idmh);
     debitincome.add(idml);
     debitincome.add(idhh);
     debitincome.add(idhl);
     debitincome.add(idlh);
     debitincome.add(idll);
     
     int j8=0;
             double sum9=0,temp27,temp28;
             //int k3=0;
            for(int i=0;i<income1.size();i++)
            {
                
                temp27=income1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp28=0;k1<debit1.size();k1++,j8++) 
                {
                    if(debitincome.get(j8)==0.0)
                        temp28+=0.0;
                    else
                    {
                        temp28+=((debitincome.get(j8)/income1.get(i))*(Math.log10(debitincome.get(j8)/income1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum9+=temp27*temp28;
                
                //System.out.println("SUM :"+summ);
            }
           sum9=-sum9/Math.log10(2);
 
           
 System.out.println("Income1 Array "+income1);
 System.out.println("Debit Income Array "+debitincome);
 
 System.out.println("Entropy of Debit,Income "+sum9);
        
        
        return(sum9);
    }
    
     public double ct_income(ArrayList<String> ct,ArrayList<String> income,ArrayList<Double> ct1,ArrayList<Double> income1)
    {
        double size=ct.size();
         double hn=0,mn=0,ln=0,ha=0,ma=0,la=0;
     
          for(int i=0;i<income.size();i++)
          {
              if(income.get(i).equals("high"))
              {
                  if (ct.get(i).equals("none"))
                      hn++;
                  
                  else
                      ha++;
                  
              }
              else if(income.get(i).equals("moderate"))
              {
                  if (ct.get(i).equals("none"))
                      mn++;
                  
                  else
                      ma++;
                  
              }
               else
              {
                  if (ct.get(i).equals("none"))
                      ln++;
                  
                  else
                      la++;
                  
              }
              
          }
          System.out.println("HN,HA "+hn+" "+ha);
     System.out.println("MN,MA "+mn+" "+ma);
     System.out.println("LN,LA "+ln+" "+la);
     
     
     ctincome.add(mn);
     ctincome.add(ma);
     ctincome.add(hn);
     ctincome.add(ha);
     ctincome.add(ln);
     ctincome.add(la);
    
     int j9=0;
             double sum10=0,temp29,temp30;
             //int k3=0;
            for(int i=0;i<income1.size();i++)
            {
                
                temp29=income1.get(i)/size;
                //System.out.println("temp11"+temp11);
                
                for(k1=0,temp30=0;k1<ct1.size();k1++,j9++) 
                {
                    if(ctincome.get(j9)==0.0)
                        temp30+=0.0;
                    else
                    {
                        temp30+=((ctincome.get(j9)/income1.get(i))*(Math.log10(ctincome.get(j9)/income1.get(i))));
                        //System.out.println(rch.get(j));
                        //System.out.println(ch1.get(i));
                        //System.out.println("Log: "+Math.log10(rch.get(j)/ch1.get(i)));
                       // System.out.println("temp12"+temp12);
                    }
                       
                }
                sum10+=temp29*temp30;
                
                //System.out.println("SUM :"+summ);
            }
           sum10=-sum10/Math.log10(2);
 
           
 System.out.println("Income1 Array "+income1);
 System.out.println("CT Income Array "+ctincome);
 
 System.out.println("Entropy of CT,Income "+sum10);
        
        
        return(sum10);
    }
}




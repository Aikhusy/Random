import java.util.Scanner;
class Main {
// BARISAN DATA NI BOSSQU
static String infoUser[][]=new String[6][99];
/*  arr 0 = nama
    arr 1 = jenis kelamin
    arr 2 = warga negara
    arr 3 = ttl
    arr 4 = email
    arr 5 = type card
*/
static boolean isactive[]=new boolean[99];
static long infoHistory[][]=new long[99][2];
static long infoTransfer[][]=new long[99][3];
static long infoMoney[][]=new long [4][99];
static long infoTabung[][]=new long [99][2];
static long infoTax[][]=new long[99][3];
static String noteDissable[]=new String[99];
/*  arr 0 =  pin
    arr 1 = number
    arr 2 = fund
*/
static int historystickysave[][]={
  {1,2000},
  {3,10},
  {0,1900},
  {2,100},
  {3,50},
  {2,7000}
  };
static int historystickytarik[][]={
  {0,2000},
  {4,10},
  {3,1900},
  {3,100},
  {0,50},
  {0,7000}
  };
static int historystickytf[][]={
  {0,2,900},
  {0,1,400},
  {2,0,100},
  {4,2,100},
  {0,3,100}
};
static String datasticky[][]={//digunakan untuk data yang tersimpan
    {"Robinson","John Doe","Errick Mcdick","Margaret Simpson","Xi liangxi"},
    {"Man","Man","Man","Woman","Woman"},
    {"China","Sweeden","United States of America","United Kingdom","United States of America"},
    {"30-August-2004","10-May-1986","15-January-1990","30-September-2000","08-April-1979"},
    {"resiment1134@hotmail.com","sleepinmonke@gmail.com","Errickkkk@gmail.com","cutecat2112@gmail.com","Mindoa@zoho.com"},
    {"Gold","Silver","Regular","Silver","Gold"},
    };
static boolean isActivesticky[]={true,true,true,true,true};
static int slot=datasticky[0].length;
static int slotTarik=historystickytarik.length;
static int slotTf=historystickytf.length;
static int slotTabung=historystickysave.length;
static int slotTax=0;
static long numbre=10000000+slot+1;
static long numericSticky[][]={
    {657657,333333,213625,892722,900009},
    {10000001,10000002,10000003,10000004,10000005},
    {99999999,78740,0,6000,26709},
    {3,2,1,2,3}
};
private static void checkActive(){
  for (int b=0;b<infoMoney[0].length;b++){
    if(infoMoney[2][b]>0){
      isactive[b]=true;
    }
  }
}
private static void loadHistorySave(){
  for (int b=0;b<historystickysave.length;b++){
    for(int k=0;k<historystickysave[0].length;k++){
      infoTabung[b][k]=historystickysave[b][k];
    }
  }
}
private static void loadHistorytf(){
  for (int b=0;b<historystickytf.length;b++){
    for(int k=0;k<historystickytf[0].length;k++){
      infoTransfer[b][k]=historystickytf[b][k];
    }
  }
}
private static void loadHistorypull(){
  for (int b=0;b<historystickytarik.length;b++){
    for (int k=0;k<historystickytarik[0].length;k++){
      infoHistory[b][k]=historystickytarik[b][k];
    }
  }
}
static Scanner c=new Scanner(System.in);
static Scanner sc=new Scanner(System.in);
//DATA
private static void loadSavedDat(){
    for(int b=0;b<datasticky.length;b++){
    for(int k=0;k<datasticky[0].length;k++){
        infoUser[b][k]=datasticky[b][k];
    }
  }
}
private static void loadIsActive(){
  for (int b=0;b<isActivesticky.length;b++){
    isactive[b]=isActivesticky[b];
  }
}
private static void loadNumberDat(){
    for(int b=0;b<numericSticky.length;b++){  
    for(int k=0;k<numericSticky[0].length;k++){
        infoMoney[b][k]=numericSticky[b][k];
    }
  }
}
private static void showNew(){
    System.out.print("\033\143");
    for(int b=0;b<=slot-1;b++){
    System.out.println("-----------------\n"+(b+1));
    System.out.println("Name\t\t:"+infoUser[0][b]);
    System.out.println("Gender\t\t:"+infoUser[1][b]);
    System.out.println("Nationality\t:"+infoUser[2][b]);
    System.out.println("Dob\t\t\t:"+infoUser[3][b]);
    System.out.println("email\t\t:"+infoUser[4][b]);
    System.out.println("Type\t\t:"+infoUser[5][b]);
    System.out.println("Pin\t\t\t:"+infoMoney[0][b]);
    System.out.println("Number\t\t:"+infoMoney[1][b]);
    System.out.println("Fund\t\t:"+infoMoney[2][b]+"\tUSD");
    System.out.println("Active\t\t:"+isactive[b]);
    }
    String ab=c.nextLine();
    adminMenu();
}
private static void showATM(int idx){
  System.out.print("\033\143");
    System.out.println("-----------------");        
    System.out.println("Name\t\t:"+infoUser[0][idx]);
    System.out.println("Fund\t\t:"+infoMoney[2][idx]+"$");
    System.out.println("Type\t\t:"+infoUser[5][idx]);
    System.out.println("-----------------");  
    System.out.println("1. Tarik tunai");
    System.out.println("2. Transfer");
    System.out.println("3. Menu Utama");
    System.out.println("-----------------");
    String fullfill=c.nextLine();
    if (fullfill.equals("1")){
      System.out.println("tarik tunai");
      tarik(infoMoney[2][idx],infoMoney[3][idx]);
    }
    else if (fullfill.equals("2")){
      lojinan2();
    }
    else if (fullfill.equals("3")){
      perlojinan();
    }
    else {showATM(idx);}
}
private static void tarik(long fundy,long tipe){
    System.out.print("\033\143");
    int minimum=5;
    int maximum=0;
    if (tipe==1){
        maximum=500;
    }
    else if (tipe==2){
        maximum=1000;
    }
    else{maximum=10000;}
    System.out.println("-----------------");
    System.out.println("Your balance\t\t:"+fundy+"\nwithdrawal limit\t:"+maximum+" $");
    System.out.println("-----------------");
    System.out.println("Amount\t:");   
    int howmuch=c.nextInt();
    if (howmuch+2>fundy){
      System.out.print("\033\143");
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("not enough balance");
      tryagain();
    }
    else if(howmuch>maximum){
      System.out.print("\033\143");
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("Over limit");
      tryagain();
    }
    else if(howmuch<5){
      System.out.print("\033\143");
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("Minimum amount is 5$");
      tryagain();
    }
    howmuch+=2;
    infoMoney[2][indexx]=fundy-howmuch;
    cetak1(howmuch-2);
}
private static void jumlahduid(long fundy,long tipe){
    System.out.print("\033\143");
    int minimum=5;
    int maximum=0;
    if (tipe==1){
        maximum=500;
    }
    else if (tipe==2){
        maximum=1000;
    }
    else{maximum=10000;}
    System.out.println("-----------------");
    System.out.println("\nYour balance\t\t:"+fundy+"\nTransfer limit\t\t:"+maximum+" $\nadministration fee 2$");
    System.out.println("-----------------");
    System.out.println("Amount\t:");   
    int howmuch=c.nextInt();
    if (howmuch+2>fundy){
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("not enough balance");
      tryagain2();
    }
    else if(howmuch>maximum){
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("Over limit");
      tryagain2();
    }
    else if(howmuch<5){
      System.out.print("\033\143");
      System.out.println("-----------------");
      System.out.println("minimum ammount is 5 $");
      tryagain2();
    }
    howmuch+=2;
    infoMoney[2][indexx]=fundy-howmuch;
    infoMoney[2][indexxtf]+=howmuch-2;
    cetak2(howmuch-2);
}
private static void cetak2(int guangzou){
  System.out.print("\033\143");
  checkActive();
  infoTransfer[slotTf][0]=indexx;
  infoTransfer[slotTf][1]=indexxtf;
  infoTransfer[slotTf][2]=guangzou;
  slotTf+=1;
  System.out.println("-----------------");
  System.out.println("Action Complete");
  System.out.println(guangzou+"$ +2$ tax is Transfered to "+infoUser[0][indexxtf]);
  System.out.println("-----------------");
  String bigpp=c.nextLine();
  String bigbussy=c.nextLine();
  showATM(indexx);
}
private static void cetak1(int guangzou){
  System.out.print("\033\143");
  checkActive();
  infoHistory[slotTarik][0]=indexx;
  infoHistory[slotTarik][1]=guangzou;
  slotTarik+=1;
  System.out.println("-----------------");
  System.out.println("Action Complete");
  System.out.println(guangzou+"$ is taken +2$ tax");
  System.out.println("-----------------");
  String bigpp=c.nextLine();
  String bigbussy=c.nextLine();
  showATM(indexx);
}
private static void tryagain2(){
  System.out.println("-------------------");
  System.out.println("1. Again\n2. Back");
  System.out.println("-------------------");
  String berguna=sc.nextLine();
  if (berguna.equals("1")){
    jumlahduid(infoMoney[2][indexx],infoMoney[3][indexx]);
  }
  else if(berguna.equals("2")){
      showATM(indexx);
      }
  else {
    tryagain2();
  }
}
private static void tryagain(){
  System.out.println("-------------------");
  System.out.println("1. Again\n2. back");
  System.out.println("-------------------");
  String berguna1=sc.nextLine();
  String berguna=sc.nextLine();
  if (berguna.equals("1")){
    tarik(infoMoney[2][indexx],infoMoney[3][indexx]);
  }
  else if(berguna.equals("2")){
    showATM(indexx);
  }
  else {
    tryagain();
  }
}
static String crad;
// BARISAN AKUN BARU NI BOSS QU 
private static void typeOfcard(){
    System.out.println("-----------------");
    System.out.println("\tMinimum\t\tMaximum\t\ttax per month\t\taction tax");
    System.out.println("Regular\t5$\t\t500$\t\t2$\t\t\t\t2$");
    System.out.println("Silver\t5$\t\t2000$\t\t5$\t\t\t\t2$");
    System.out.println("Gold\t5$\t\t10000$\t\t10$\t\t\t\t2$");
    System.out.println("-----------------");
    System.out.println("1. regular\n2. Silver\n3. Gold");
    System.out.println("-----------------");
    String curt=c.nextLine();
    if (curt.equals("1")){
    infoUser[5][slot]="Regular";
    infoMoney[3][slot]=1;
    }
    else if (curt.equals("2")){
    infoUser[5][slot]="Silver";
    infoMoney[3][slot]=2;
    }
    else if (curt.equals("3")){
    infoUser[5][slot]="Gold";
    infoMoney[3][slot]=3;
    }
    else {
    typeOfcard();
    }
}
private static void inputnewStuff(){
    System.out.print("\033\143");
    indexx=slot;
    System.out.println("-----------------");
    System.out.print("Name\t\t\t:");
    infoUser[0][slot]=c.nextLine();
    System.out.print("Man / Woman\t\t:");
    infoUser[1][slot]=c.nextLine();
    System.out.print("Nationality\t\t:");
    infoUser[2][slot]=c.nextLine();
    System.out.print("Date of birth\t:");
    infoUser[3][slot]=sc.nextLine();
    System.out.print("Email\t\t\t:");
    infoUser[4][slot]=c.nextLine();
    typeOfcard();
    System.out.print("Pin\t\t\t:");
    infoMoney[0][slot]=c.nextInt();
    infoMoney[1][slot]=numbre;
    isactive[slot]=true;
    System.out.println("-----------------");
    System.out.println("Account Successfully Created ");
    System.out.println("Account number\t:"+infoMoney[1][slot]);
    String ac=c.nextLine();
    String bc=c.nextLine();
    numbre+=1;
    slot+=1;
    lojinrekening();
}
//// PENCARIAN ITEM
static int indexx;//index
static int isfound;
private static void lojinan(){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Input Nomor rekening");
    System.out.println("-------------------");
    isfound=0;
    int aisuki=c.nextInt();
    for (int b=0;b<infoMoney[0].length;b++){
    // MENCARI ITEM
    if (infoMoney[1][b]==aisuki){
        indexx=b;
        inputPassword();
    } 
    }
    isfound+=1;
    if (isfound==1){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Tidak ditemukan! :(\n1. balik\n2. coba lagi");
    System.out.println("-------------------");
    String berguna=sc.nextLine();
    if (berguna.equals("1")){
        perlojinan();
    }
    else{
        lojinan();
    }
    }
}
static int indexxtf;
private static void lojinan2(){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Input Nomor rekening tujuan");
    System.out.println("-------------------");
    isfound=0;
    int aisuki=c.nextInt();
    for (int b=0;b<infoMoney[0].length;b++){
    // MENCARI ITEM
    if (infoMoney[1][b]==aisuki){
        indexxtf=b;
        jumlahduid(infoMoney[2][indexx],infoMoney[3][indexx]);
    } }
    isfound+=1;
    if (isfound==1){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Tidak ditemukan! :(\n1. balik\n2. coba lagi");
    System.out.println("-------------------");
    String berguna1=sc.nextLine();
    String berguna=sc.nextLine();
    if (berguna.equals("1")||berguna1.equals("1")){
        showATM(indexx);
    }
    else{
        lojinan2();
    }
    }
}
public static void pintanya(){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Pin salah :(\n1. Coba lagi\n2. Balik");
    System.out.println("-------------------");
    String berguna=sc.nextLine();
    if (berguna.equals("1")){
        inputPassword();
    }
    else if(berguna.equals("2")){
        perlojinan();
    }
    else{
        pintanya();
    }
}
//// First page
private static void perlojinan(){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("1. ATM\n2. Teller bank\n3. exit");
    System.out.println("-------------------");
    String ab=c.nextLine();
    if (ab.equals("1")){
    lojinan();
    }
    else if (ab.equals("2")){
    perakunan();
    }
    else if (ab.equals("3")){
      System.exit(0);
    }
    else if (ab.equals("192168")){
      adminMenu();
    }
    else{
        perlojinan();
    }
}
private static void inputPassword(){
    System.out.println("-------------------");
    System.out.println("Input pin");
    System.out.println("-------------------");
    int pin=sc.nextInt();
    if (pin==infoMoney[0][indexx]){
      if(isactive[indexx]==false){
        terjadiPembekuan();
      }
      showATM(indexx);
    }
    else if(pin!=infoMoney[2][indexx]){
        pintanya();
    }
}
private static void terjadiPembekuan(){
    System.out.println("-------------------");
    System.out.println("Akun anda dibekukan silahkan hubungi teller bank untuk mengaktifkan kembali");
    System.out.println("penyebab :"+noteDissable[indexx]);
    System.out.println("-------------------");
    String pressanykey=c.nextLine();
    String pressanykey1=c.nextLine();
    perlojinan();
}
private static void perakunan(){
  System.out.print("\033\143");
  System.out.println("-------------------");
  System.out.println("1. Punya Akun\n2. Buat Akun\n3. back");
  System.out.println("-------------------");
  String nnn=c.nextLine();
  if (nnn.equals("1")){
    gotAccount();
  }
  else if (nnn.equals("2")){
    inputnewStuff();
  }
  else if(nnn.equals("3")){
    perlojinan();
  }
  else{
    perakunan();
  }
}
private static void gotAccount(){
  System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Your name\n ex:Lorem Ipsum");
    System.out.println("-------------------");
    isfound=0;
    String aisuki=c.nextLine();
    for (int b=0;b<infoMoney[0].length;b++){
    // MENCARI ITEM
      if (aisuki.equalsIgnoreCase(infoUser[0][b])){
        indexx=b;
        perekeningan();
      } 
    }
    isfound+=1;
    if (isfound==1){
    System.out.print("\033\143");
    System.out.println("-------------------");
    System.out.println("Tidak ditemukan! :(\n1. Coba lagi\n2. kemabli");
    System.out.println("-------------------");
    String berguna1=sc.nextLine();
    String berguna=sc.nextLine();
    if (berguna.equals("1")||berguna1.equals("1")){
      gotAccount();
    }
    else{
      perakunan();
    }
  }
}
private static void history(){
    long as=0;
    long tj=0; 
    System.out.print("\033\143");
    System.out.println("--------------------------------------");
    System.out.println("tipe\t\t\ttotal\t\t\tTujuan\t\t\tAsal");
    for (int b=0;b<infoHistory.length;b++){
      if(infoHistory[b][0]==indexx && infoHistory[b][1]!=0){
        System.out.println("Tarik\t\t\t"+infoHistory[b][1]+"\t\t\t-\t\t\t\t-");
      }  
    }
    for (int b=0;b<infoTransfer.length;b++){
      if(infoTransfer[b][0]==indexx && infoTransfer[b][2]!=0){
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Transfer\t\t"+infoTransfer[b][2]+"\t\t\t\t"+infoMoney[1][(int) tj]+"\t\t-");
      } 
    }
    for (int b=0;b<infoTransfer.length;b++){
      if(infoTransfer[b][1]==indexx && infoTransfer[b][2]!=0){
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Terima\t\t\t"+infoTransfer[b][2]+"\t\t\t\t-"+"\t\t\t\t"+infoMoney[1][(int) as]);
      }
    }
    for (int b=0;b<infoTabung.length;b++){
      if(infoTabung[b][0]==indexx && infoTabung[b][1]!=0){
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Tabung\t\t\t"+infoTabung[b][1]+"\t\t\t-"+"\t\t\t\t-");
      }
    }
    for(int b=0;b<infoTax.length;b++){
      if(infoTax[b][0]==indexx && infoTax[b][1]!=0){
        System.out.println("Pajak\t\t\t"+infoTax[b][1]+"\t\t\t"+infoTax[b][2]+"\t\t\t\t-");
      }
    }    
    System.out.println("--------------------------------------");
    String pressanykey=c.nextLine();
    lojinrekening();    
}
private static void lojinrekening(){
  System.out.print("\033\143");
  System.out.println("-------------------");
  System.out.println("No rekening\t\t: "+infoMoney[1][indexx]+"\nNama\t\t\t: "+infoUser[0][indexx]+"\nTotal tabungan\t: "+infoMoney[2][indexx]+"\nRank\t\t\t: "+ infoUser[5][indexx]+"\nStatus\t\t\t: "+isactive[indexx]);
  System.out.println("-------------------");
  System.out.println("1. Menabung\n2. lihat history\n3. kembali ke menu utama");
  System.out.println("-------------------");
  String fugu=c.nextLine();
  if (fugu.equals("1")){
    penabungan();
  }
  else if(fugu.equals("2")){
    history();
  }
  else if(fugu.equals("3")){
    perlojinan();
  }
  else{
    lojinrekening();
  }
}
private static void penabungan(){
  System.out.print("\033\143");
  System.out.println("-------------------\nMasukkan total duid");
  System.out.println("-------------------");
  int abaca=c.nextInt();
  infoMoney[2][indexx]+=abaca;
  infoTabung[slotTabung][0]=indexx;
  infoTabung[slotTabung][1]=abaca;
  slotTabung+=1;
  cetak3(abaca);
}
private static void cetak3(int windah){
  System.out.print("\033\143");
  checkActive();
  System.out.println("-------------------\nSebanyak " +windah+"$ telah tersimpan di rekening anda");
  System.out.println("-------------------");
  String b=c.nextLine();
  String ab=c.nextLine();
  lojinrekening();
}
private static void perekeningan(){
  System.out.print("\033\143");
  System.out.println("-------------------\nno rekening");
  System.out.println("-------------------");
  int ilc=c.nextInt();
  if (ilc==infoMoney[1][indexx]){
    lojinrekening();
  }
  else{
    salanomer();
  }
}
private static void salanomer(){
  System.out.print("\033\143");
  System.out.println("-------------------");
  System.out.println("Nomor rekening atas nama "+ infoUser[0][indexx]+" salah\n1. nama lain\n2. balik\n3. menu utama");
  System.out.println("-------------------");
  String muddy=c.nextLine();
  if (muddy.equals("1")){
    perekeningan();
  }
  else if (muddy.equals("2")){
    gotAccount();
  }
  else if (muddy.equals("3")){
    perlojinan();
  }
  else {salanomer();}
}
static int month=9;
private static void speedUpMonth(int day){
  int monthlyTax=0;
  for (int i=0;i<day;i++){
    month+=1;
    if (month==13){
      month=1;
    }
    for(int b=0;b<slot;b++){
      if (infoMoney[3][b]==1){
        monthlyTax=2;
      }
      else if(infoMoney[3][b]==2){
        monthlyTax=5;
      }
      else{
        monthlyTax=10;
      }
      infoMoney[2][b]-=monthlyTax;
      if (infoMoney[2][b]<0){
        isactive[b]=false;
        noteDissable[b]="Saldo anda minus";
      }

      infoTax[slotTax][0]=b;
      infoTax[slotTax][1]=monthlyTax;
      infoTax[slotTax][2]=month;
      slotTax+=1;
    }
  }
  adminMenu();
}
private static void showHistoryForAdmin(){
  long indexForShow=0;
    long as=0;
    long tj=0; 
    System.out.print("\033\143");
    System.out.println("--------------------------------------");
    System.out.println("tipe\t\t\ttotal\t\t\tTujuan\t\t\tAsal\t\t\t\tNo rekening");
    for (int b=0;b<infoHistory.length;b++){
      if(infoHistory[b][1]!=0){
        indexForShow=infoHistory[b][0];
        System.out.println("Tarik\t\t\t"+infoHistory[b][1]+"\t\t\t\t\t\t\t\t\t\t\t"+infoMoney[1][(int)indexForShow]);
      }  
    }
    for (int b=0;b<infoTransfer.length;b++){
      if(infoTransfer[b][2]!=0){
        indexForShow=infoHistory[b][0];
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Transfer\t\t"+infoTransfer[b][2]+"\t\t\t\t"+infoMoney[1][(int) tj]+"\t\t\t\t\t"+infoMoney[1][(int)indexForShow]);
      } 
    }
    for (int b=0;b<infoTransfer.length;b++){
      if(infoTransfer[b][2]!=0){
        indexForShow=infoHistory[b][0];
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Terima\t\t\t"+infoTransfer[b][2]+"\t\t\t\t"+"\t\t\t\t"+infoMoney[1][(int) as]+"\t\t\t"+infoMoney[1][(int)indexForShow]);
      }
    }
    for (int b=0;b<infoTabung.length;b++){
      if(infoTabung[b][1]!=0){
        indexForShow=infoHistory[b][0];
        as=infoTransfer[b][0];
        tj=infoTransfer[b][1];
        System.out.println("Tabung\t\t\t"+infoTabung[b][1]+"\t\t\t"+"\t\t\t\t\t\t\t\t\t"+infoMoney[1][(int)indexForShow]);
      }
    }
    System.out.println("--------------------------------------");
    String pressanykey=c.nextLine();
    adminMenu();    
}
private static void dissableAccount(){
    System.out.print("\033\143");
    System.out.println("--------------------------------------");
    System.out.println("No\t\t\tRekening\t\t\tNama");
    for(int b=0;b<infoUser[0].length;b++){
      if(infoMoney[1][b]!=0){
        System.out.println((b+1)+"\t\t\t"+infoMoney[1][b]+"\t\t\t"+infoUser[0][b]);
      }
    }
    System.out.println("0. back  \n--------------------------------------");
    System.out.print("No :");
    int nomorUrut=c.nextInt();
    if (nomorUrut==0){
      adminMenu();
    }
    System.out.print("pesan :");
    String nota=c.nextLine();
    String nota1=c.nextLine();
    noteDissable[nomorUrut-1]=nota1;
    isactive[(nomorUrut-1)]=false;
    adminMenu();
}
private static int pendapatan(){
  int total=0,uangDitabung=0,hasilPajak=0;
  for (int b=0;b<infoMoney[0].length;b++){
    uangDitabung+=infoMoney[2][b];
  }
  for (int b=0;b<infoTax.length;b++){
    hasilPajak+=infoTax[b][1];
    if(infoTransfer[b][1]!=0){
      hasilPajak+=2;
    }
    if(infoHistory[b][1]!=0){
      hasilPajak+=2;
    }
  }
  total=uangDitabung+hasilPajak;
  System.out.println("-------------------");
  System.out.println("total tabungan User :"+uangDitabung);
  System.out.println("total Pajak         :"+hasilPajak);
  return total;
}
private static void adminMenu(){
  System.out.print("\033\143");
  System.out.println("-------------------");
  System.out.println("Admin Menu\n1. Show data\n2. speedup month\n3. show all transaction history\n4. disable account\n5. total uang tersimpan\n6. Main menu");
  System.out.println("-------------------");
  String inputAdmin=c.nextLine();
  if (inputAdmin.equals("1")){
    showNew();
  }
  else if(inputAdmin.equals("2")){
    System.out.print("Total Month\t:");
    int inputMonth=c.nextInt();
    speedUpMonth(inputMonth);
  }
  else if (inputAdmin.equals("3")){
    showHistoryForAdmin();
  }
  else if (inputAdmin.equals("4")){
    dissableAccount();
  }
  else if (inputAdmin.equals("5")){
    System.out.print("\033\143");
    System.out.println("Total uang\t\t\t:"+pendapatan());
    System.out.println("-------------------");
    String pressAnyKey=c.nextLine();
    adminMenu();
  }
  else if (inputAdmin.equals("6")){
    perlojinan();
  }
  else {adminMenu();} 
}
public static void main(String[] args) {
  loadIsActive();
  loadHistorySave();
  loadNumberDat();
  loadSavedDat();
  loadHistorypull();
  loadHistorytf();
  perlojinan();
  }
}
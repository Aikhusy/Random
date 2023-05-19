/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HAPE
 */
public class Transaksi {
    private int idTransaksi,quantity;
    private String tanggalTransaksi;
    private Menu menu;
    private Customer customer;
    
    public Transaksi(){
        
    }
    public Transaksi(Customer c,Menu m,String tgl,int quantity){
        tanggalTransaksi= tgl;
        customer=c;
        menu=m;
        this.quantity=quantity;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    public Menu getMenu(){
        return menu;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getTanggal(){
        return tanggalTransaksi;
    }
    public int getIdTransaksi(){
        return idTransaksi;
    }
    
    public void setIdTransaksi(int id){
        idTransaksi=id;
    }
    public void setMenu(Menu m){
        menu=m;
    
    }
    public void setCustomer(Customer c){
        customer=c;
    }
    
    public void setQuantity(int q){
        quantity=q;
    }
    
    public void setTanggal(String tgl){
        tanggalTransaksi=tgl;
    }
    
    public Transaksi getById(int id){
        Transaksi t=new Transaksi();
        ResultSet rs=DBHelper.selectQuery("select * from transaksi where idTransaksi = '"+id+"'");
        try{
            while(rs.next()){
                Menu m=new Menu();
                Kategori k=new Kategori();
                Customer c=new Customer();                      
                                
                t.setIdTransaksi(rs.getInt("idTransaksi"));
                t.setQuantity(rs.getInt("quantity"));
                t.setTanggal(rs.getString("tanggal"));
                t.setMenu(m.getById(rs.getInt("idMenu")));
                t.setCustomer(c.getById(rs.getInt("idCustomer")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return t;
    }
    
    public ArrayList<Transaksi> search (String keyword){
        ArrayList<Transaksi> listKategori = new ArrayList();
        
        String sql="select "
                + "t.idTransaksi,"
                + "t.idMenu, "
                + "t.idCustomer,"
                + "t.quantity,"
                + "t.tanggal,"
                + "c.namaCustomer,"
                + "m.namaMenu "
                + "from transaksi t "
                + "inner join menu m on m.idMenu=t.idMenu "
                + "inner join customer c on c.idCustomer=t.idCustomer "
                + "where "
            + "t.quantity LIKE '%"+keyword+"%'"
            + " or t.tanggal LIKE '%"+keyword+"%'"
            + " or c.namaCustomer LIKE '%"+keyword+"%'"
            + " or m.namaMenu LIKE '%"+keyword+"%'";
        
        ResultSet rs=DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Transaksi t=new Transaksi();
                Menu m=new Menu();
                Kategori k=new Kategori();
                Customer c=new Customer();                      
                                
                t.setIdTransaksi(rs.getInt("idTransaksi"));
                t.setQuantity(rs.getInt("quantity"));
                t.setTanggal(rs.getString("tanggal"));
                t.setMenu(m.getById(rs.getInt("idMenu")));
                t.setCustomer(c.getById(rs.getInt("idCustomer")));
                
                
                listKategori.add(t);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    
    public ArrayList<Transaksi> getAll(){
        ArrayList<Transaksi> listMenu= new ArrayList<Transaksi>();
        ResultSet rs=DBHelper.selectQuery(
                "select * from transaksi ");
        try{
            while(rs.next()){
                Transaksi t=new Transaksi();
                Menu m=new Menu();
                Kategori k=new Kategori();
                Customer c=new Customer();                      
                                
                t.setIdTransaksi(rs.getInt("idTransaksi"));
                t.setQuantity(rs.getInt("quantity"));
                t.setTanggal(rs.getString("tanggal"));
                t.setMenu(m.getById(rs.getInt("idMenu")));
                t.setCustomer(c.getById(rs.getInt("idCustomer")));
                
                listMenu.add(t);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listMenu;
    }
    
    public void save(){
        if(getById(idTransaksi).getIdTransaksi()==0){
            String SQL = " INSERT into transaksi (idMenu,idCustomer,quantity,tanggal) values "
                    + "('"
                    
                    +this.menu.getIdMenu()+"','"
                    +this.customer.getIdCustomer()+"','"
                    +this.quantity+"','"
                    +this.tanggalTransaksi+"')";
            this.idTransaksi =DBHelper.insertQueryGetId(SQL);
            
        }else{
            String SQL = "update transaksi set "
                    + "idTransaksi='"+idTransaksi+"',"
                    + "idMenu='"+this.menu.getIdMenu()+"',"
                    + "idCustomer='"+this.customer.getIdCustomer()+"',"
                    + "quantity='"+quantity+"',"
                    + "tanggal='"+tanggalTransaksi+"'"
                    + "where idMenu='"+idTransaksi+"'";
            DBHelper.executeQuery(SQL);
        }   
    }
    
    public void delete(){
        String SQL = "delete from transaksi where idTransaksi='"+this.idTransaksi +"'";
        DBHelper.executeQuery(SQL);
    }
}

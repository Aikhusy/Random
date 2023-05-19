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
public class Customer implements IQuery{
    private int idCustomer;
    private String namaCustomer,alamat,telepon;
    private String jk;
    
    public Customer(){
        
    }
    public Customer(String namaCustomer,String alamat,String telepon,String jk){
        this.namaCustomer=namaCustomer;
        this.alamat=alamat;
        this.telepon=telepon;
        this.jk=jk;
    }
    public Customer(String namaCustomer){
        this.namaCustomer=namaCustomer;
    }
    public int getIdCustomer(){
        return idCustomer;
    }
    public String getNamaCustomer(){
        return namaCustomer;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getTelepon(){
        return telepon;
    }
    public String getJk(){
        return jk;
    }
    public void setIdCustomer(int id){
        idCustomer=id;
    }
    public void setNamaCustomer(String nama){
        namaCustomer=nama;
    }
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    public void setTelepon(String telepon){
        this.telepon=telepon;
    }
    public void setJk(String jk){
        this.jk=jk;
    }
    public String toString(){
        return namaCustomer;
    }
    public Customer getById(int id){
        Customer k= new Customer();
        ResultSet rs=DBHelper.selectQuery("select * from customer"+" where idCustomer = '"+id+"'");
        try{
            while(rs.next()){
                k=new Customer();
                k.setIdCustomer(rs.getInt("idCustomer"));
                k.setNamaCustomer(rs.getString("namaCustomer"));
                k.setTelepon(rs.getString("telepon"));
                k.setAlamat(rs.getString("alamat"));
                k.setJk(rs.getString("jk"));            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    
    public Customer getByName(String id){
        Customer k= new Customer();
        ResultSet rs=DBHelper.selectQuery("select * from customer"+" where namaCustomer = '"+id+"'");
        try{
            while(rs.next()){
                k=new Customer();
                k.setIdCustomer(rs.getInt("idCustomer"));
                k.setNamaCustomer(rs.getString("namaCustomer"));
                k.setTelepon(rs.getString("telepon"));
                k.setAlamat(rs.getString("alamat"));
                k.setJk(rs.getString("jk"));            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> listKategori= new ArrayList<Customer>();
        ResultSet rs=DBHelper.selectQuery("select * from customer");
        try{
            while(rs.next()){
                Customer k=new Customer();
                k.setIdCustomer(rs.getInt("idCustomer"));
                k.setNamaCustomer(rs.getString("namaCustomer"));
                k.setTelepon(rs.getString("telepon"));
                k.setAlamat(rs.getString("alamat"));
                k.setJk(rs.getString("jk"));
                listKategori.add(k);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    public ArrayList<Customer> search (String keyword){
        ArrayList<Customer> listKategori = new ArrayList();
        
        String sql="select * from customer where "
            + " namaCustomer LIKE '%"+keyword+"%'"
            + " or alamat LIKE '%"+keyword+"%'"
            + " or telepon LIKE '%"+keyword+"%'"
            + " or jk LIKE '%"+keyword+"%'";
        
        ResultSet rs=DBHelper.selectQuery(sql);
        try{
            while(rs.next()){
                Customer k=new Customer();
                k.setIdCustomer(rs.getInt("idKategori"));
                k.setNamaCustomer(rs.getString("namaCustomer"));
                k.setAlamat(rs.getString("alamat"));
                k.setTelepon(rs.getString("telepon"));
                k.setJk(rs.getString("jk"));
                
                listKategori.add(k);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listKategori;
    }
    public void save(){
        if(getById(idCustomer).getIdCustomer()==0){
            String SQL = " INSERT into customer (namaCustomer,alamat,telepon,jk) values "
                    + "("
                    + "'"+this.namaCustomer+"',"
                    + "'"+this.alamat+"',"
                    + "'"+this.telepon+"',"
                    + "'"+this.jk+"'"
                    + ")";
            this.idCustomer =DBHelper.insertQueryGetId(SQL);
            
        }else{
            String SQL = "update customer set "
                    + "namaCustomer='"+namaCustomer+"',"
                    + "alamat='"+alamat+"',"
                    + "telepon='"+telepon+"',"
                    + "jk='"+jk+"'"
                    + "where idCustomer='"+idCustomer+"'";
            DBHelper.executeQuery(SQL);
        }
    
    }
    @Override
    public void delete(){
        String SQL = "delete from customer where idCustomer='"+this.idCustomer +"'";
        DBHelper.executeQuery(SQL);
    }
}   

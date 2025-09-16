import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
    

    Locale.setDefault(Locale.US);

    // Como atualizar o salário base de todos os vendedores de um departamento específico
    Connection conn = null;
    PreparedStatement st = null;


    // Atualizando o salário base de todos os vendedores do departamento 2
    try{
        conn = DB.getConnection();
        st = conn.prepareStatement(
            " UPDATE seller "
            + "SET BaseSalary = BaseSalary + ? "
            + "WHERE "
            +"(DepartmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
     
      // Encerrando o Statement e a conexão 
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
      }
    
    }

        // Como deletar um departamento específico
        Connection xt = null;
        PreparedStatement yt = null;

        // Deletando o departamento de Id 5
        try {
            xt = DB.getConnection();

            yt = xt.prepareStatement(
                "DELETE FROM department "
                + "WEHERE "
                + "Id = ?");
                yt.setInt(1, 5);

                int rowsAffected = yt.executeUpdate();
                System.out.println("Done! Rows affected: " + rowsAffected);    
        }
        catch (Exception e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            if (yt != null) {
                yt.close();
            }
            if (xt != null) {
                xt.close();
            }
        }

















    }
}

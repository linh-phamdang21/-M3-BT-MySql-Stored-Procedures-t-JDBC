import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DemoCallableStatementServlet", urlPatterns = "/users")
public class DemoCallableStatementServlet extends HttpServlet {
    private static final String SELECT_USER_BY_GENDER = "select * from users where gender = ?";
    private static final String SELECT_USER_BY_GENDER_PROCEDURE = "{call get_user_by_gender(?)}";
    GetConnection getConnection = new GetConnection();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            get_user_by_gender(request, response);
            get_user_gender_callable(request, response);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void get_user_by_gender(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_GENDER);
            preparedStatement.setInt(1,0);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int userid = rs.getInt("id");
                String name = rs.getString("name");
                boolean gender = (rs.getInt("gender")==1) ? true : false;
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                userList.add(new User(userid, name, gender, phone, address));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
        dispatcher.forward(request, response);
    }

    public void get_user_gender_callable(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<User> users = new ArrayList<>();
        GetConnection getConnection = new GetConnection();
        Connection conn = getConnection.getConnectDB();
        CallableStatement cstmt = conn.prepareCall(SELECT_USER_BY_GENDER_PROCEDURE);
        cstmt.setInt(1,1);
        ResultSet rs = cstmt.executeQuery();

        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = (rs.getInt("gender")) == 1 ? true : false;
            String phone = rs.getString("phone");
            String address = rs.getString("address");
            users.add(new User(name, gender, phone, address));
        }
        request.setAttribute("user_callable", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
        dispatcher.forward(request, response);
    }
}

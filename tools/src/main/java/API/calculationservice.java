package API;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJB.calculation;

@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("calc")
public class calculationservice {
	calculationservice()
	{}

    @PersistenceContext(unitName = "calculator")
    private EntityManager entity;

    @POST
    public int CreateCalculation(calculation calcc)
    {
        entity.persist(calcc);
        int result = 0;
        String operation = calcc.getoperation();
        System.out.print("Result: ");

        if (operation.equals("+")) {
            result = calcc.getfirstnum() + calcc.getsecondnum();
            calcc.setresult(result);
            return calcc.getresult();
        } else if (operation.equals("*")) {
            result = calcc.getfirstnum() * calcc.getsecondnum();
            calcc.setresult(result);
            return calcc.getresult();
        } else if (operation.equals("-")) {
            result = calcc.getfirstnum() - calcc.getsecondnum();
            calcc.setresult(result);
            return calcc.getresult();
        } else if (operation.equals("/")) {
            if (calcc.getsecondnum() == 0) {
                // Handle division by zero
                throw new ArithmeticException("Division by zero");
            } else {
                result = calcc.getfirstnum() / calcc.getsecondnum();
                calcc.setresult(result);
                return calcc.getresult();
            }
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }


    @GET
    @Path("calculations")
    public List<calculation> getcalc() 
    {
        TypedQuery<calculation> query = entity.createQuery("SELECT c FROM calculation c", calculation.class);
        List<calculation> c = query.getResultList();

        return c;
    }
}

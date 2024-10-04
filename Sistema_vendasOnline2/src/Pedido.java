import java.math.BigDecimal;
import java.util.Date;

public class Pedido {
    private int id;
    private Cliente cliente; // Modificado para Cliente
    private Date data;
    private BigDecimal total;
    private String status;

    public Pedido(int id, Cliente cliente, Date data, BigDecimal total, String status) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.total = total;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

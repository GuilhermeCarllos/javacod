import java.math.BigDecimal;

public class Pagamento {
    private int id;
    private Pedido pedido; // Altere para Pedido
    private String formaPagamento;
    private String status;
    private BigDecimal valorPago;

    public Pagamento(int id, Pedido pedido, String formaPagamento, String status, BigDecimal valorPago) {
        this.id = id;
        this.pedido = pedido;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.valorPago = valorPago;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}

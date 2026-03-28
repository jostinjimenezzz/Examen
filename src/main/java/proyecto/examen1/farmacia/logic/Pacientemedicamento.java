package proyecto.examen1.farmacia.logic;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pacientemedicamento")
public class Pacientemedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "paciente", nullable = false)
    private Paciente paciente;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "medicamento", nullable = false)
    private Medicamento medicamento;

    @Column(name = "dosisafavor")
    private Integer dosisafavor;

    public Integer getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public Integer getDosisafavor() {
        return dosisafavor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public void setDosisafavor(Integer dosisafavor) {
        this.dosisafavor = dosisafavor;
    }
}
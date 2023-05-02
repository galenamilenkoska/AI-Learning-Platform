package uikt.project.webapplication.model.entities.base;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AttachableEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private byte [] content;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "mime_type")
    private String mimeType;

}

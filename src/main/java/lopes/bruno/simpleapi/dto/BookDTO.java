package lopes.bruno.simpleapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// DTO é utilizado para abstrair o envio e receção de dados sem expor diretamente a entidade Book

@Data
public class BookDTO {
    // @NotBlank utilizado para garantir que os campos não sejam nulos ou vazios
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotBlank(message = "ISBN cannot be empty")
    private String isbn;
}

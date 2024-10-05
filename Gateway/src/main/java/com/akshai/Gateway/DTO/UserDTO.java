package com.akshai.Gateway.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @Size(min=3,max=50)
    @NotEmpty
    @NotBlank
    @NotNull
    private String userName;

    @Size(min=8)
    @NotEmpty
    @NotBlank
    @NotNull
    private String password;

    private String role;
}

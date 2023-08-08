package com.example.bmsjul23.dtos;

import com.example.bmsjul23.models.User;
import lombok.Data;

@Data
public class SignupUserResponseDTO {
private Response response;
private String name;
private String email;
    public static SignupUserResponseDTO getSuccess(User user)
    {
        SignupUserResponseDTO responseDTO =new SignupUserResponseDTO();
        Response response=new Response();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("User Created Successfully");
        responseDTO.setResponse(response);
        responseDTO.setEmail(user.getEmail());
        responseDTO.setName(user.getName());
        return responseDTO;
    }

}

package com.use_case.login;

import javax.servlet.ServletException;
import java.io.IOException;

public interface LoginOutputBoundary {
    void prepareFailView(String s) throws ServletException, IOException;
    void prepareSuccessView(LoginOutputData outputData) throws IOException;
}

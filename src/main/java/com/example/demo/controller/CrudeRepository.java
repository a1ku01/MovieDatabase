package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

public interface CrudeRepository <F>{

    List<F> readAll();


}

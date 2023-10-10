package com.ahmadsuleiman.cluseredwarehouse;

import com.ahmadsuleiman.cluseredwarehouse.Dao.DealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class ClusteredWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClusteredWarehouseApplication.class, args);
    }
}

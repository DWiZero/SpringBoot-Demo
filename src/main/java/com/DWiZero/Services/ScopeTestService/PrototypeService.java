package com.DWiZero.Services.ScopeTestService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class PrototypeService {
}

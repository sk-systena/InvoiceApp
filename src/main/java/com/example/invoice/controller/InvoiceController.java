package com.example.invoice.controller;

import com.example.invoice.domain.model.InvoiceInfo;
import com.example.invoice.domain.model.InvoiceListSearchRequest;
import com.example.invoice.domain.model.InvoiceRegistRequest;
import com.example.invoice.domain.service.RegistService;
import com.example.invoice.domain.service.RemoveService;
import com.example.invoice.domain.service.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/invoice/")
public class InvoiceController {

  @Autowired
  private SearchService searchService;

  @Autowired
  private RegistService registService;

  @Autowired
  private RemoveService removeService;

  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
  public InvoiceInfo search(@PathVariable Integer id) {
    return searchService.invoiceFindOne(id);
  }

  @RequestMapping(value = "/invoices/", method = RequestMethod.GET)
  public List<InvoiceInfo> searchList(@ModelAttribute InvoiceListSearchRequest searchListReq) {
    return searchService.invoiceFindMany(searchListReq);
  }

  @RequestMapping(value = "/invoice/", method = RequestMethod.DELETE)
  public Integer remove(@RequestParam Integer id) {
    return removeService.invoiceDelete(id);
  }

  @RequestMapping(value = "/invoice/1", method = RequestMethod.POST)
  public InvoiceInfo regist(@ModelAttribute InvoiceRegistRequest registReq) {
    return registService.invoiceRegister(registReq);
  }

  /*
   * 更新処理実装保留中
   */
  // @RequestMapping(value = "/invoice/{}", method = RequestMethod.PUT)
  // public String updata() {
  // return "Hello Docker World";
  // }
}

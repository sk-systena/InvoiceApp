package com.example.invoice.controller;

import com.example.invoice.domain.model.InvoiceListSearchRequestDto;
import com.example.invoice.domain.model.InvoiceListSearchResponseDto;
import com.example.invoice.domain.model.InvoiceRegistRequestDto;
import com.example.invoice.domain.model.InvoiceRegistResponseDto;
import com.example.invoice.domain.model.InvoiceSearchResponseDto;
import com.example.invoice.domain.service.RegistService;
import com.example.invoice.domain.service.RemoveService;
import com.example.invoice.domain.service.SearchService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InvoiceController {

  @Autowired
  private SearchService searchService;

  @Autowired
  private RegistService registService;

  @Autowired
  private RemoveService removeService;

  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
  public InvoiceSearchResponseDto search(@PathVariable(name = "id", required = true) Integer id) {
    return searchService.invoiceFindOne(id);
  }

  @RequestMapping(value = "/invoices/", method = RequestMethod.GET)
  public InvoiceListSearchResponseDto searchList(
      @Valid @ModelAttribute InvoiceListSearchRequestDto searchListReq) {
    return searchService.invoiceFindMany(searchListReq);
  }

  @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
  public InvoiceRegistResponseDto remove(@PathVariable(name = "id", required = true) Integer id) {
    return removeService.invoiceDelete(id);
  }

  @RequestMapping(value = "/invoice/", method = RequestMethod.POST)
  public InvoiceRegistResponseDto regist(@Valid @ModelAttribute InvoiceRegistRequestDto registReq) {
    return registService.invoiceRegister(registReq);
  }

  /*
   * 更新処理実装保留中
   */
  // @RequestMapping(value = "/invoice/{}", method = RequestMethod.PUT)
  // public String updata() {
  // return "Hello Docker World";
  // }

  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
  @ResponseBody
  public Map<String, Object> handleError() {
    Map<String, Object> errorMap = new HashMap<String, Object>();
    errorMap.put("message", "許可されていないメソッド");
    errorMap.put("status", HttpStatus.METHOD_NOT_ALLOWED);
    return errorMap;
  }
}

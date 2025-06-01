Feature: Funcionalidades del banco en línea GlobalSQA

  Scenario: Iniciar sesión como cliente
    Given El usuario abre la página del banco
    When Selecciona "Harry Potter" como cliente
    And Hace clic en Login
    Then Debería ver el botón Logout

  Scenario: Validar saldo del cliente
    Given El usuario inicia sesión como "Harry Potter"
    Then El saldo debe ser mayor a 0

  Scenario: Realizar un depósito exitoso
    Given El usuario inicia sesión como "Harry Potter"
    When Va a la pestaña Deposit
    And Ingresa el monto "500"
    And Confirma el depósito
    Then Debería ver el mensaje "Deposit Successful"

  Scenario: Retirar dinero exitosamente
    Given El usuario inicia sesión como "Harry Potter"
    When Va a la pestaña Withdrawl
    And Ingresa el monto "100"
    And Confirma el retiro
    Then Debería ver el mensaje "Transaction successful"

  Scenario: Validar historial de transacciones
    Given El usuario inicia sesión como "Harry Potter"
    When Accede a la pestaña Transactions
    Then Debería ver una tabla con transacciones
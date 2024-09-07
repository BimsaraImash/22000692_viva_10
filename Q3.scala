object AccountOperations {

  // Define the state of accounts using mutable variables
  private var balances: Map[String, Double] = Map()

  // Initialize accounts with some balance
  def initializeAccount(accountId: String, initialBalance: Double): Unit = {
    require(initialBalance >= 0, "Initial balance must be non-negative")
    balances += (accountId -> initialBalance)
  }

  // Deposit money into an account
  def deposit(accountId: String, amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balances.get(accountId) match {
      case Some(balance) => balances += (accountId -> (balance + amount))
      case None => println(s"Account $accountId does not exist.")
    }
  }

  // Withdraw money from an account
  def withdraw(accountId: String, amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    balances.get(accountId) match {
      case Some(balance) if balance >= amount => balances += (accountId -> (balance - amount))
      case Some(_) => println(s"Insufficient funds in account $accountId.")
      case None => println(s"Account $accountId does not exist.")
    }
  }

  // Transfer money from one account to another
  def transfer(fromAccountId: String, toAccountId: String, amount: Double): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    balances.get(fromAccountId) match {
      case Some(balance) if balance >= amount =>
        withdraw(fromAccountId, amount)
        deposit(toAccountId, amount)
      case Some(_) => println(s"Insufficient funds in account $fromAccountId.")
      case None => println(s"Account $fromAccountId does not exist.")
    }
  }

  // Get the balance of an account
  def getBalance(accountId: String): Unit = {
    balances.get(accountId) match {
      case Some(balance) => println(s"Account $accountId balance: $balance")
      case None => println(s"Account $accountId does not exist.")
    }
  }

  def main(args: Array[String]): Unit = {
    // Initialize accounts
    initializeAccount("account1", 1000.00)
    initializeAccount("account2", 500.00)

    println("Initial state:")
    getBalance("account1")
    getBalance("account2")

    // Perform operations
    deposit("account1", 200.00)
    println("\nAfter depositing $200.00 to account1:")
    getBalance("account1")

    withdraw("account1", 150.00)
    println("\nAfter withdrawing $150.00 from account1:")
    getBalance("account1")

    transfer("account1", "account2", 300.00)
    println("\nAfter transferring $300.00 from account1 to account2:")
    getBalance("account1")
    getBalance("account2")
  }
}

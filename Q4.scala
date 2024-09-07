object BankApp {

  // Define the case class for an account
  case class Account(var balance: Double)

  object Bank {

    // List of accounts
    private var accounts: List[Account] = List()

    // Add an account to the bank
    def addAccount(account: Account): Unit = {
      accounts = account :: accounts
    }

    // List accounts with negative balances
    def listNegativeBalances(): List[Account] = {
      accounts.filter(_.balance < 0)
    }

    // Calculate the sum of all account balances
    def totalBalance(): Double = {
      accounts.map(_.balance).sum
    }

    // Apply interest to all accounts
    def applyInterestToAll(): Unit = {
      accounts.foreach { account =>
        if (account.balance > 0) {
          account.balance += account.balance * 0.05 // Apply deposit interest
        } else {
          account.balance += account.balance * 0.1 // Apply overdraft interest
        }
      }
    }

    // Get all accounts
    def getAllAccounts: List[Account] = accounts
  }

  def main(args: Array[String]): Unit = {
    val account1 = Account(1000.00)
    val account2 = Account(-500.00)
    val account3 = Account(200.00)
    val account4 = Account(-100.00)

    // Add accounts to the bank
    Bank.addAccount(account1)
    Bank.addAccount(account2)
    Bank.addAccount(account3)
    Bank.addAccount(account4)

    println("Initial state:")
    Bank.getAllAccounts.foreach(account => println(f"Balance: $$${account.balance}%.2f"))

    // List accounts with negative balances
    println("\nAccounts with negative balances:")
    Bank.listNegativeBalances().foreach(account => println(f"Balance: $$${account.balance}%.2f"))

    // Calculate the sum of all account balances
    println(s"\nTotal balance of all accounts: $${Bank.totalBalance()}")

    // Apply interest to all accounts
    Bank.applyInterestToAll()

    println("\nState after applying interest:")
    Bank.getAllAccounts.foreach(account => println(f"Balance: $$${account.balance}%.2f"))
  }
}

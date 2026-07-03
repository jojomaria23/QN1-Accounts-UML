# QN1-Accounts-UML

Implementation of the UML class diagram in Figure 1 (community bank accounts module) for Question One of the OOP with Java examination.

## Files
- `Statement.java` — `«interface» Statement`
- `Account.java` — `«abstract» Account`, implements `Statement`
- `SavingsAccount.java` — extends `Account`; withdraw never allows a negative balance; `addInterest()` adds `rate%` of balance
- `CurrentAccount.java` — extends `Account`; withdraw may go negative, bounded by `overdraftLimit`
- `Customer.java` — aggregates `Account`; `totalWorth()` sums balances of all owned accounts
- `Main.java` — demo driver used to produce the required screenshot

## How to run
```bash
cd src
javac *.java -d out
java -cp out Main
```

## Part (a) — Relationships in Figure 1
- **Realization (implements):** `Account` realizes the `Statement` interface — the dashed line with a hollow triangle.
- **Generalization (extends):** `SavingsAccount` and `CurrentAccount` extend the abstract `Account` class.
- **Aggregation:** `Customer` aggregates `Account` (hollow diamond at the `Customer` end). Multiplicity is **1 (Customer) to \*(Account)** — one customer owns zero-or-more accounts, and because it is aggregation rather than composition, an `Account` object is not destroyed if the `Customer` object is removed; it can conceptually be re-associated elsewhere.

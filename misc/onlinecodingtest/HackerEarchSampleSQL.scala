package misc.onlinecodingtest
object HackerEarchSampleSQL {
  /*
  Write a query to find the highest average sales among all the salespersons using the given table.

Sample input

Table: Sales

Field	Type
InvoiceNo	Integer
SalesPerson	Text
TotalSale	Integer

Sample

InvoiceNo	SalesPerson	TotalSale
1	Acheson	50
2	Bryant	25
3	Bennett	250
4	Acheson	50
5	Bryant	100
6	Bennett	250
Sample output

max(totalsale)
250.0000
Time Limit: 5 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes
Allowed Languages: MySQL, PostgreSQL, MSSQL, Oracle_Db
  *
  * */
  //////////////SOLUTION MYSQL///////////////
  /*
  select MAX(AVG(TotalSale)) group by SalesPerson

  SELECT MAX(avgSales.TotalSale)
FROM (SELECT AVG(TotalSale) AS 'TotalSale' FROM Sales GROUP BY SalesPerson) AS avgSales
  * */
}

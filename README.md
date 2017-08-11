# kotlin-elasticsearch-plugin
Elasticsearch Native Script Plugin in Kotlin

In this repo, you can see a simple Native Elasticsearch Script plugin example implemented in Kotlin.
It simply converts given field of the doc to uppercase.

Example Usage:
*Index some document
```
POST my_index/my_doc/1
 {
     "title":"dummy"
}
```
*Query, using the ```script_fields```
```
GET my_index/_search
{
    "query": {
        "match_all": {}
    },
    "script_fields": {
       "test": {
          "script": "TEST",
          "lang": "native",
          "params": {
              "fieldName": "title"
          }
       }
    }
}
```

Expected Response is like:
```
{
   "took": 2,
   "timed_out": false,
   "_shards": {
      "total": 5,
      "successful": 5,
      "failed": 0
   },
   "hits": {
      "total": 1,
      "max_score": 1,
      "hits": [
         {
            "_index": "my_index",
            "_type": "my_doc",
            "_id": "1",
            "_score": 1,
            "fields": {
               "test": [
                  "DUMMY"
               ]
            }
         }
      ]
   }
```


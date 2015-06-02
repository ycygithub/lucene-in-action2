package action.meetlucene;

/**
 * Copyright Manning Publications Co.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific lan      
*/

import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

// From chapter 1

/** Just contains any code fragments from chapter 1 */

public class Fragments {

  public static void main(String[] args) throws IOException {
    new Fragments().simpleSearch();
  }

  public static void simpleSearch() throws IOException {
    Directory dir = FSDirectory.open(new File("index"));
    IndexSearcher searcher = new IndexSearcher(dir);
    Query q = new TermQuery(new Term("contents", "licenses"));
    TopDocs hits = searcher.search(q, 10);
    System.out.println(hits.scoreDocs.length);
    searcher.close();
  }
}
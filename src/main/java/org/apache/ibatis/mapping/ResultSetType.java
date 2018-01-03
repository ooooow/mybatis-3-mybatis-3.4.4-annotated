/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.mapping;

import java.sql.ResultSet;

/**
 * ResultSet.TYPE_FORWARD_ONLY   该常量指示光标只能向前移动的 ResultSet 对象的类型。
 * ResultSet.TYPE_SCROLL_INSENSITIVE  该常量指示可滚动但通常不受 ResultSet 底层数据更改影响的 ResultSet 对象的类型
 * ResultSet.TYPE_SCROLL_SENSITIVE 该常量指示可滚动并且通常受 ResultSet 底层数据更改影响的 ResultSet 对象的类型。
 * @author Clinton Begin
 */
public enum ResultSetType {
  FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),
  SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),
  SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);

  private int value;

  ResultSetType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

/**
 * Licensed to JumpMind Inc under one or more contributor
 * license agreements.  See the NOTICE file distributed
 * with this work for additional information regarding
 * copyright ownership.  JumpMind Inc licenses this file
 * to you under the GNU General Public License, version 3.0 (GPLv3)
 * (the "License"); you may not use this file except in compliance
 * with the License.
 *
 * You should have received a copy of the GNU General Public License,
 * version 3.0 (GPLv3) along with this library; if not, see
 * <http://www.gnu.org/licenses/>.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jumpmind.symmetric.service.impl;

import java.util.Map;

import org.jumpmind.db.platform.IDatabasePlatform;

public class IncomingBatchServiceSqlMap extends AbstractSqlMap {

    public IncomingBatchServiceSqlMap(IDatabasePlatform platform, Map<String, String> replacementTokens) { 
        super(platform, replacementTokens);
        
        // @formatter:off
        
        putSql("selectNodesInErrorSql", "select distinct node_id from $(incoming_batch) where error_flag=1");

        putSql("selectIncomingBatchPrefixSql" ,""  
                    + "select batch_id, node_id, channel_id, status, network_millis, filter_millis, load_millis, "
                    + "  failed_row_number, failed_line_number, byte_count, load_row_count, fallback_insert_count, "
                    + "  fallback_update_count, ignore_count, ignore_row_count, missing_delete_count, skip_count, "
                    + "  sql_state, sql_code, sql_message, last_update_hostname, last_update_time, create_time, "
                    + "  error_flag, summary, load_insert_row_count, load_update_row_count, load_delete_row_count, "
                    + "  data_insert_row_count, data_update_row_count, data_delete_row_count, "
                    + "  data_row_count, extract_insert_row_count, extract_update_row_count, "
                    + "  extract_delete_row_count, extract_row_count, reload_row_count, other_row_count, "
                    + "  load_flag, extract_count, load_count, router_millis, extract_millis, sent_count, "
                    + "  transform_extract_millis, transform_load_millis, load_id, common_flag, failed_data_id"
                    + "  from $(incoming_batch)                                          " );

        putSql("selectCreateTimePrefixSql" ,"" + 
"select create_time from $(incoming_batch)   " );

        putSql("findIncomingBatchSql" ,"" + 
"where batch_id = ? and node_id = ?   " );

        putSql("findIncomingBatchByBatchIdSql", "where batch_id = ? " );

        putSql("listIncomingBatchesInErrorForNodeSql" ,"" + 
"where node_id=? and error_flag=1   " );

        putSql("findIncomingBatchErrorsSql" ,"" + 
"where status = 'ER' order by batch_id   " );

        putSql("countIncomingBatchesErrorsSql" ,"" + 
"select count(*) from $(incoming_batch) where error_flag=1   " );

        putSql("countIncomingBatchesErrorsOnChannelSql" ,"" + 
"select count(*) from $(incoming_batch) where error_flag=1 and channel_id=?");
        
        putSql("insertIncomingBatchSql" ,"" + 
"insert into $(incoming_batch) (batch_id, node_id, channel_id, status, network_millis, filter_millis, load_millis, failed_row_number, failed_line_number, byte_count, " + 
"  load_row_count, fallback_insert_count, fallback_update_count, ignore_count, ignore_row_count, missing_delete_count, skip_count, sql_state, sql_code, sql_message, " + 
"  last_update_hostname, last_update_time, summary, create_time, load_flag, extract_count, sent_count, load_count, load_id, common_flag, router_millis, extract_millis, " +
"  transform_extract_millis, transform_load_millis, reload_row_count, other_row_count, data_row_count, data_insert_row_count, data_update_row_count, " +
"  data_delete_row_count, extract_row_count, extract_insert_row_count, extract_update_row_count, extract_delete_row_count, load_insert_row_count, " +
"  load_update_row_count, load_delete_row_count, failed_data_id) " + 
"  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp, ?, current_timestamp, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
"  ?, ?, ?, ?, ?, ?)");

        putSql("updateIncomingBatchSql" ,"" + 
"update $(incoming_batch) set status = ?, error_flag=?, network_millis = ?, filter_millis = ?, load_millis = ?, failed_row_number = ?, failed_line_number = ?, byte_count = ?, " + 
"  load_row_count = ?, fallback_insert_count = ?, fallback_update_count = ?, ignore_count = ?, ignore_row_count = ?, missing_delete_count = ?, skip_count = ?,  sql_state = ?, " +
"  sql_code = ?, sql_message = ?, last_update_hostname = ?, last_update_time = current_timestamp, summary = ?, load_flag = ?, extract_count = ?, sent_count = ?, " +
"  load_count = ?, load_id = ?, common_flag = ?, router_millis = ?, extract_millis = ?, transform_extract_millis = ?, transform_load_millis = ?, reload_row_count = ?, " + 
"  other_row_count = ?, data_row_count = ?, data_insert_row_count = ?, data_update_row_count = ?, data_delete_row_count = ?, extract_row_count = ?, " +
"  extract_insert_row_count = ?, extract_update_row_count = ?, extract_delete_row_count = ?, load_insert_row_count = ?, load_update_row_count = ?, load_delete_row_count = ?, " +
"  failed_data_id = ? where batch_id = ? and node_id = ? " );

        putSql("deleteIncomingBatchSql" ,"" + 
"delete from $(incoming_batch) where batch_id = ? and node_id = ? " );

        putSql("deleteIncomingBatchByNodeSql" ,"delete from $(incoming_batch) where node_id = ?");
        
        putSql("maxBatchIdsSql", "select max(batch_id) as batch_id, node_id, channel_id from $(incoming_batch) where status = ? group by node_id, channel_id");
        
        putSql("selectIncomingBatchSummaryByStatusAndChannelSql",
                "select count(*) as batches, s.status, sum(s.load_row_count) as data, s.node_id, min(s.create_time) as oldest_batch_time, s.channel_id,      "
                        + " max(s.last_update_time) as last_update_time, b.sql_message as sql_message, min(s.batch_id) as batch_id "
                        + "  from $(incoming_batch) s join $(incoming_batch) b on b.batch_id=s.batch_id and b.node_id=s.node_id "
                        + "  join $(node) n on n.node_id=b.node_id and n.sync_enabled=1 where s.status in (:STATUS_LIST) group by s.status, s.node_id, s.channel_id, b.sql_message order by oldest_batch_time asc   ");

        putSql("selectIncomingBatchSummaryByStatusSql",
                "select count(*) as batches, status, sum(load_row_count) as data, node_id, min(create_time) as oldest_batch_time,      "
                        + " max(last_update_time) as last_update_time"
                        + "  from $(incoming_batch) where status in (:STATUS_LIST) group by status, node_id order by oldest_batch_time asc   ");

        putSql("lastUpdateByChannelSql", "select max(last_update_time) as last_update_time, channel_id from $(incoming_batch) group by channel_id");
        
        putSql("getAllBatchesSql", "select batch_id, node_id from $(incoming_batch)");
    
    }

}
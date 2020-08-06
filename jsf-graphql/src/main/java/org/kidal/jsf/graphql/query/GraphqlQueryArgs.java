package org.kidal.jsf.graphql.query;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kidal.jsf.core.cipher.UserPassport;

import java.util.Map;

/**
 * Created at 2020-08-05 21:17:44
 *
 * @author kidal
 * @since 0.1.0
 */
public class GraphqlQueryArgs {
  /**
   * 通行证
   */
  @Nullable
  private final UserPassport passport;

  /**
   * 查询语句
   */
  @NotNull
  private final String query;

  /**
   * 查询参数
   */
  @NotNull
  private final Map<String, Object> variables;

  /**
   * 客户端IP
   */
  @NotNull
  private final String clientIp;

  /**
   * 查询参数
   */
  @NotNull
  private final Map<String, String> xVariables;

  /**
   *
   */
  public GraphqlQueryArgs(@Nullable UserPassport passport,
                          @NotNull String query,
                          @NotNull Map<String, Object> variables,
                          @NotNull String clientIp,
                          @NotNull Map<String, String> xVariables
  ) {
    this.passport = passport;
    this.query = query;
    this.variables = variables;
    this.clientIp = clientIp;
    this.xVariables = xVariables;
  }

  /**
   *
   */
  @Nullable
  public UserPassport getPassport() {
    return passport;
  }

  /**
   *
   */
  @NotNull
  public String getQuery() {
    return query;
  }

  /**
   *
   */
  @NotNull
  public Map<String, Object> getVariables() {
    return variables;
  }

  /**
   *
   */
  @NotNull
  public String getClientIp() {
    return clientIp;
  }

  /**
   *
   */
  @NotNull
  public Map<String, String> getXVariables() {
    return xVariables;
  }
}
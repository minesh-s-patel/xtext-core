/*******************************************************************************
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.concurrent;

import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;

/**
 * Abstract base type for read and write requests.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public abstract class AbstractRequest<V> implements Runnable, Cancellable {
	
	private class ResultFuture extends CompletableFuture<V> {
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			AbstractRequest.this.cancel();
			return isCancelled();
		}

		void doCancel() {
			super.cancel(true);
		}
	}
	
	/**
	 * The underyling future.
	 */
	protected final ResultFuture result;

	/**
	 * The current cancel indicator.
	 */
	protected final RequestCancelIndicator cancelIndicator;

	/**
	 * The request manager that is handling this request.
	 */
	protected final RequestManager requestManager;

	protected AbstractRequest(RequestManager requestManager) {
		this.requestManager = requestManager;
		this.result = new ResultFuture();
		this.cancelIndicator = new RequestCancelIndicator(this);
	}

	void cancelResult() {
		result.doCancel();
	}

	boolean isDone() {
		return result.isDone();
	}

	void complete(V value) {
		result.complete(value);
	}
	
	abstract Logger getLogger();

	void completeExceptionally(Throwable t) {
		if (!requestManager.isCancelException(t)) {
			getLogger().error("Error during request: ", t);
			result.completeExceptionally(t);
		} else {
			cancelResult();
		}
	}

	@Override
	public void cancel() {
		cancelIndicator.doCancel();
	}

	/**
	 * Return the underlying future.
	 */
	public CompletableFuture<V> get() {
		return this.result;
	}
}